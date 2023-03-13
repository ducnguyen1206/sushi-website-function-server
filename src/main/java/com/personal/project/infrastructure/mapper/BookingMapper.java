package com.personal.project.infrastructure.mapper;

import com.personal.project.domain.dto.booking.BookingDto;
import com.personal.project.infrastructure.entity.form.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface BookingMapper {
    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);

    BookingDto bookingToBookingRequestDto(Booking booking);

    Booking bookingRequestDtoToBooking(BookingDto bookingDto);
}
