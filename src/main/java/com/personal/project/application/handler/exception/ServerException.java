package com.personal.project.application.handler.exception;

import lombok.Getter;

@Getter
public class ServerException extends RuntimeException {

    private final String message;

    public ServerException(String message) {
        super(message);
        this.message = message;
    }
}
