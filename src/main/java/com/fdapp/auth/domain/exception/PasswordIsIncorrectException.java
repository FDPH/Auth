package com.fdapp.auth.domain.exception;

public class PasswordIsIncorrectException extends RuntimeException {
    public PasswordIsIncorrectException(String message) {
        super(message);
    }
}
