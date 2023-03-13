package com.personal.project.domain.dto.booking;

import com.personal.project.domain.dto.booking.error.BookingError;
import com.personal.project.domain.dto.common.ServerError;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {
    private BookingDto bookingDto;
    private BookingErrorResponse bookingErrorResponse;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class BookingErrorResponse {
        private BookingError error;
        private ServerError serverError;
    }
}
