package com.personal.project.infrastructure.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = Booking.TABLE_NAME)
public class Booking {

    public static final String TABLE_NAME = "BOOKING";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "booking_id")
    private String bookingId;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "number_of_guests")
    private int numberOfGuests;
    @Column(name = "reservation_date")
    private LocalDateTime reservationTime;
    @Column(name = "branch_id")
    private String branchId;
    @Column(name = "special_notes")
    private String specialNotes;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @Column(name = "created_by")
    private String createdBy;
}
