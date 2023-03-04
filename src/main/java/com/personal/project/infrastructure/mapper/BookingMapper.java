package com.personal.project.infrastructure.mapper;

import com.personal.project.domain.dto.form.BookingDto;
import com.personal.project.infrastructure.entity.form.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface BookingMapper {
    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);

    BookingDto bookingToBookingDto(Booking booking);

    Booking bookingDtoToBooking(BookingDto bookingDto);
}
