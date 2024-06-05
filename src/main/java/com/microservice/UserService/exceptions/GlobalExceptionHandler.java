package com.microservice.UserService.exceptions;

import org.apache.http.HttpStatus;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
    ApiResponse apiResponse;
    @ExceptionHandler(ResourceNotFoundException.class)
    public ApiResponse handlerResourceNotFoundException(ResourceNotFoundException ex){
        String message = ex.getMessage();
        apiResponse.setMessage(message);
        apiResponse.setSuccess(true);
        apiResponse.setStatus(HttpStatus.SC_NOT_FOUND);

        return apiResponse;
    }

}
