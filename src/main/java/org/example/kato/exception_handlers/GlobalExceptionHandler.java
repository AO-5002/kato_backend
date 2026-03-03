package org.example.kato.exception_handlers;

import org.example.kato.exceptions.ApplicationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ErrorResponse> handleApplicationException(ApplicationException e) {
        ErrorResponse error = new ErrorResponse(e.getMessage(), e.getHttpStatus().value());
        return ResponseEntity.status(e.getHttpStatus()).body(error);
    }

}
