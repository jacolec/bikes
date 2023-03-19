package com.bikerent.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BikeNotFoundException.class)
    public ResponseEntity<Object> handleBikeNotFoundException(BikeNotFoundException exception) {
        return new ResponseEntity<>("Bike not found!", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException exception) {
        return new ResponseEntity<>("User not found!", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PriceListNotFoundException.class)
    public ResponseEntity<Object> handlePriceListNotFoundException(PriceListNotFoundException exception) {
        return new ResponseEntity<>("Price list not found!", HttpStatus.NOT_FOUND);
    }
}
