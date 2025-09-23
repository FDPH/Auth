package com.fdapp.auth.domain.exception;

public class UserDoNotExistByUserName extends RuntimeException {
    public UserDoNotExistByUserName(String message) {
        super(message);
    }
}
