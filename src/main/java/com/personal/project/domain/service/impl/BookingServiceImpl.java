package com.personal.project.domain.service.impl;

import com.personal.project.domain.dto.branch.BranchDto;
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
        Optional<Branch> branch = branchRepository.findByBranchId(bookingRequest.getBranchId());
        if (branch.isEmpty()) {
            // TODO THROW ERROR
            return null;
        }

        BranchDto branchDto = BranchMapper.INSTANCE.branchToBranchDto(branch.get());
        Booking booking = BookingMapper.INSTANCE.bookingDtoToBooking(bookingRequest);
        BookingDto bookingResponse = BookingMapper.INSTANCE.bookingToBookingDto(bookingRepository.save(booking));
        bookingResponse.setBranchName(branchDto.getBranchName());

        return bookingResponse;
    }

    @Override
    public List<BranchDto> getAllBranches() {
        List<Branch> branchList = branchRepository.findAll();
        return BranchMapper.INSTANCE.listBranchToListBranchDto(branchList);
    }
}
