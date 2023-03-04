package com.personal.project.domain.dto.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {
    private Long id;
    private String bookingId;
    private String customerName;
    private String phoneNumber;
    private String email;
    private int numberOfGuests;
    private LocalDateTime reservationTime;
    private String branchId;
    private String branchName;
    private String specialNotes;
    private LocalDateTime createdDate;
    private String createdBy;
}
