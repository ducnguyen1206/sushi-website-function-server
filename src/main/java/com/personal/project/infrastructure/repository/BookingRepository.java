package com.personal.project.infrastructure.repository;

import com.personal.project.infrastructure.entity.form.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
