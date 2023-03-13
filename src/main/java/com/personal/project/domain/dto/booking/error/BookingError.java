package com.personal.project.domain.dto.booking.error;

import lombok.Getter;

import static com.personal.project.domain.dto.booking.error.BookingErrorCode.ECB001;
import static com.personal.project.domain.dto.booking.error.BookingErrorCode.ECB002;

@Getter
public enum BookingError {
    INVALID_REQUEST(ECB001.name(), "Invalid Request"),
    DATA_NOT_FOUND(ECB002.name(), "Data not Found");


    private final String code;
    private final String message;

    BookingError(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
