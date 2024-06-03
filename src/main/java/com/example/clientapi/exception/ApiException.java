package com.example.clientapi.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiException extends RuntimeException{

    private final HttpStatus status;
    private final String statusCode;
    private final String message;

    public ApiException(String message, HttpStatus status){
        super(message);
        this.status = status;
        this.message = message;
        this.statusCode = String.valueOf(status.value());
    }

    public ApiException(String message){
        super(message);
        this.message = message;
        this.status = null;
        this.statusCode = null;
    }
}
