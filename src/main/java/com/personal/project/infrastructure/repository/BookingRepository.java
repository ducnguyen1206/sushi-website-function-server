package com.personal.project.infrastructure.repository;

import com.personal.project.infrastructure.entity.form.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {

//    @Query(select * from psp_general.booking b where branch_id = 'SG-2' and created_date::date = '2023-01-03'  order by created_date desc limit 1)
//    Optional<Booking> findTheLatestBookingIdByCreatedDateDesc(String branchId);
}
