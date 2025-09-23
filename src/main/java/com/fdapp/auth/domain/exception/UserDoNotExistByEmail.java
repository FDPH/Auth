package com.fdapp.auth.domain.exception;

public class UserDoNotExistByEmail extends RuntimeException {
    public UserDoNotExistByEmail(String message) {
        super(message);
    }
}
