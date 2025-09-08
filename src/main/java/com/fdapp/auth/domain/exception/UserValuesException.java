package com.fdapp.auth.domain.exception;

public class UserValuesException extends RuntimeException{
    public UserValuesException(String message) {
        super(message);
    }

    public UserValuesException(String message, Throwable cause) {
        super(message, cause);
    }
}
