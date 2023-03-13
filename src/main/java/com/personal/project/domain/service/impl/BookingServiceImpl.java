package com.personal.project.domain.service.impl;

import com.personal.project.domain.dto.branch.BranchDto;
import com.personal.project.domain.dto.branch.BranchIdEnum;
import com.personal.project.domain.dto.form.BookingDto;
import com.personal.project.domain.service.BookingService;
import com.personal.project.infrastructure.entity.branch.Branch;
import com.personal.project.infrastructure.entity.form.Booking;
import com.personal.project.infrastructure.mapper.BookingMapper;
import com.personal.project.infrastructure.mapper.BranchMapper;
import com.personal.project.infrastructure.repository.BookingRepository;
import com.personal.project.infrastructure.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        String branchId = bookingRequest.getBranchId();

        if (BranchIdEnum.getEnum(bookingRequest.getBranchId()) == null)
            // TODO THROW ERROR
            return null;

        Optional<Branch> branch = branchRepository.findByBranchId(branchId);
        if (branch.isEmpty())
            // TODO THROW ERROR
            return null;

        // Ex: HN-1-230313-1
        String bookingId = generateBookingId(branchId);

        bookingRequest.setBookingId(bookingId);
        bookingRequest.setBranchName(branch.get().getBranchName());
        bookingRequest.setCreatedDate(LocalDateTime.now());
        bookingRequest.setCreatedBy("Thomas Lee"); // dummy data

        Booking booking = BookingMapper.INSTANCE.bookingDtoToBooking(bookingRequest);

        return BookingMapper.INSTANCE.bookingToBookingDto(bookingRepository.save(booking));
    }

    @Override
    public List<BranchDto> getAllBranches() {
        List<Branch> branchList = branchRepository.findAll();
        return BranchMapper.INSTANCE.listBranchToListBranchDto(branchList);
    }

    private String generateBookingId(String branchId) {
        LocalDateTime localDateTime = LocalDateTime.now();

        String createdDate = localDateTime.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String bookingId = branchId + "-" + createdDate + "-";

        createdDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        createdDate = createdDate.concat("'T'00:00:00");
        Optional<Booking> booking = bookingRepository.findTheLatestBookingIdByCreatedDateDesc(branchId, createdDate);
        if (booking.isEmpty())
            return bookingId + "1"; // Ex: SG1-20230313-1

        String currentBookingId = booking.get().getBookingId();
        String maxCaseId = currentBookingId.substring(13); // The location start the case ID

        return bookingId + Long.parseLong(maxCaseId);
    }
}
