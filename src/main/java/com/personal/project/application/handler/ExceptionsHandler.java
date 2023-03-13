package com.personal.project.application.handler;

import com.personal.project.application.handler.exception.BookingException;
import com.personal.project.application.handler.exception.ServerException;
import com.personal.project.domain.dto.common.Error;
import com.personal.project.domain.dto.common.ServerError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
@Slf4j
public class ExceptionsHandler {

    @ExceptionHandler({BookingException.class})
    public ResponseEntity<Object> bookingError(BookingException exception) {
        log.error(exception.getCode() + " - " + exception.getMessage(), exception.getCause());
        Error error = new Error(exception.getCode(), exception.getMessage());
        return ResponseEntity.ok(error);
    }

    @ExceptionHandler({ServerException.class})
    public ResponseEntity<Object> serverError(ServerException exception) {
        log.error(exception.getMessage(), exception.getCause());
        ServerError error = new ServerError("Something Went Wrong");
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(error);
    }
}
