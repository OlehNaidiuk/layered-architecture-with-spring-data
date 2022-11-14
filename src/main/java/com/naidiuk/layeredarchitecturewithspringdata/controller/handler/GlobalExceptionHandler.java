package com.naidiuk.layeredarchitecturewithspringdata.controller.handler;

import com.naidiuk.layeredarchitecturewithspringdata.controller.response.ErrorResponse;
import com.naidiuk.layeredarchitecturewithspringdata.error.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler{
    @ExceptionHandler
    public ResponseEntity<?> handle(ProductNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage()));
    }
}
