package com.microservice.UserService.exceptions;


import org.apache.http.HttpStatus;

public class ApiResponse {
    String message;
    boolean success;
    HttpStatus status;

    public String getMessage(String message) {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public void setStatus(int scNotFound) {
    }
}
