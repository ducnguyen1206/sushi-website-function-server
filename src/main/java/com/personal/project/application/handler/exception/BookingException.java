package com.personal.project.application.handler.exception;

import lombok.Getter;

@Getter
public class BookingException extends RuntimeException {
    private final String code;
    private final String message;

    public BookingException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
