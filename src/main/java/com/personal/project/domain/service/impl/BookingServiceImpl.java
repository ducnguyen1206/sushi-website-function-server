package com.personal.project.domain.service.impl;

import com.personal.project.application.handler.exception.BookingException;
import com.personal.project.application.handler.exception.ServerException;
import com.personal.project.domain.dto.booking.BookingDto;
import com.personal.project.domain.dto.booking.BookingResponse;
import com.personal.project.domain.dto.booking.error.BookingError;
import com.personal.project.domain.dto.branch.BranchDto;
import com.personal.project.domain.dto.branch.BranchIdEnum;
import com.personal.project.domain.dto.common.ServerError;
import com.personal.project.domain.service.BookingService;
import com.personal.project.infrastructure.entity.branch.Branch;
import com.personal.project.infrastructure.entity.form.Booking;
import com.personal.project.infrastructure.mapper.BookingMapper;
import com.personal.project.infrastructure.mapper.BranchMapper;
import com.personal.project.infrastructure.repository.BookingRepository;
import com.personal.project.infrastructure.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Override
    public BookingDto submit(BookingDto bookingRequest) {
        BookingResponse bookingResponse = saveBookingRequest(bookingRequest);
        BookingResponse.BookingErrorResponse errorResponse = bookingResponse.getBookingErrorResponse();

        if (errorResponse != null) {
            BookingError bookingError = errorResponse.getError();
            ServerError serverError = errorResponse.getServerError();
            if (bookingError != null)
                throw new BookingException(bookingError.getCode(), bookingError.getMessage());
            else if (serverError != null)
                throw new ServerException(errorResponse.getServerError().getMessage());
        }

        return bookingResponse.getBookingDto();
    }

    public BookingResponse saveBookingRequest(BookingDto bookingDto) {
        String branchId = bookingDto.getBranchId();

        if (BranchIdEnum.getEnum(bookingDto.getBranchId()) == null)
            return getErrorResponse(BookingError.INVALID_REQUEST, null);


        Optional<Branch> branch = branchRepository.findByBranchId(branchId);
        if (branch.isEmpty())
            return getErrorResponse(BookingError.DATA_NOT_FOUND, null);

        try {
            String bookingId = generateBookingId(branchId);

            bookingDto.setBookingId(bookingId);
            bookingDto.setBranchName(branch.get().getBranchName());
            bookingDto.setCreatedDate(LocalDateTime.now());
            bookingDto.setCreatedBy("Thomas Lee"); // dummy data

            Booking booking = BookingMapper.INSTANCE.bookingRequestDtoToBooking(bookingDto);
            bookingDto = BookingMapper.INSTANCE.bookingToBookingRequestDto(bookingRepository.save(booking));
        } catch (Exception exception) {
            ServerError serverError = new ServerError(exception.getMessage());
            return getErrorResponse(null, serverError);
        }

        return BookingResponse.builder().bookingDto(bookingDto).build();
    }

    @Override
    public List<BranchDto> getAllBranches() {
        List<Branch> branchList = branchRepository.findAll();
        return BranchMapper.INSTANCE.listBranchToListBranchDto(branchList);
    }

    private String generateBookingId(String branchId) {
        String createdDate = getCreatedDateByPattern("yyyyMMdd");
        String bookingId = branchId + "-" + createdDate + "-";

        createdDate = getCreatedDateByPattern("yyyy-MM-dd").concat("'T'00:00:00");

        Optional<Booking> latestBooking = bookingRepository
                .findTheLatestBookingIdByCreatedDateDesc(branchId, createdDate);

        if (latestBooking.isEmpty())
            return bookingId + 1; // Ex: SG1-20230313-1

        String currentBookingId = latestBooking.get().getBookingId();

        // get the latest case ID and increase by 1
        long maxCaseId = Long.parseLong(currentBookingId.substring(13)) + 1;

        return bookingId + maxCaseId;
    }

    private String getCreatedDateByPattern(String pattern) {
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    private BookingResponse getErrorResponse(BookingError error, ServerError serverError) {
        BookingResponse.BookingErrorResponse bookingErrorResponse = new BookingResponse.BookingErrorResponse();
        bookingErrorResponse.setError(error);
        bookingErrorResponse.setServerError(serverError);
        return BookingResponse.builder().bookingErrorResponse(bookingErrorResponse).build();
    }
}
