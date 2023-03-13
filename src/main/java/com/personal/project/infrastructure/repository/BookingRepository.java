package com.personal.project.infrastructure.repository;

import com.personal.project.infrastructure.entity.form.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query( value = "select * from booking where branch_id = :branchId and created_date>cast(:createdDate as timestamp) " +
                    "order by created_date desc limit 1", nativeQuery = true)
    Optional<Booking> findTheLatestBookingIdByCreatedDateDesc
            (@Param("branchId") String branchId, @Param("createdDate") String createdDate);
}
