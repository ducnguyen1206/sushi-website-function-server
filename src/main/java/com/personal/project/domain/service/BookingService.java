package com.personal.project.domain.service;

import com.personal.project.domain.dto.booking.BookingDto;
import com.personal.project.domain.dto.branch.BranchDto;

import java.util.List;

public interface BookingService {
    BookingDto submit(BookingDto bookingRequest);

    List<BranchDto> getAllBranches();
}
