package com.personal.project.domain.service;

import com.personal.project.domain.dto.branch.BranchDto;
import com.personal.project.domain.dto.form.BookingDto;

import java.util.List;

public interface BookingService {
    BookingDto submit(BookingDto bookingRequest);

    List<BranchDto> getAllBranches();
}
