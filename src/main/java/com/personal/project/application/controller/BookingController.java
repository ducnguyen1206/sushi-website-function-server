package com.personal.project.application.controller;

import com.personal.project.domain.dto.form.BookingDto;
import com.personal.project.domain.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    /**
     * Api for booking
     *
     * @param bookingRequest the information of the booking
     * @return the booking information which was saved to the database
     */
    @PostMapping("/submit")
    public ResponseEntity<Object> submit(@RequestBody BookingDto bookingRequest) {
        return ResponseEntity.ok(bookingService.submit(bookingRequest));
    }

    /**
     * Api get branch for drop down button
     *
     * @return branch list
     */
    @GetMapping("/branch-list")
    public ResponseEntity<Object> getAllBranches() {
        return ResponseEntity.ok(bookingService.getAllBranches());
    }

}
