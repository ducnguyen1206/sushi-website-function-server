package com.personal.project.application.controller;

import com.personal.project.domain.dto.booking.BookingDto;
import com.personal.project.domain.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/submit")
    public ResponseEntity<Object> submit(@RequestBody BookingDto bookingRequest) {
        return ResponseEntity.ok(bookingService.submit(bookingRequest));
    }

    @GetMapping("/branch-list")
    public ResponseEntity<Object> getAllBranches() {
        return ResponseEntity.ok(bookingService.getAllBranches());
    }

}
