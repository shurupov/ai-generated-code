package com.example.matheval.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidExpressionException extends RuntimeException {
    public InvalidExpressionException(String message) {
        super(message);
    }
}
