package com.pp.sun.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> runtimeExceptionHandler(Exception ex) {
        return ResponseEntity.internalServerError().body(ex.getLocalizedMessage());
    }

    @ExceptionHandler(DuplicateTransectionException.class)
    public ResponseEntity<String> duplicateTransectionExceptionHandler(DuplicateTransectionException ex) {
        return ResponseEntity.internalServerError().body(ex.getLocalizedMessage());
    }

}
