package com.fdapp.auth.domain.exception;

public class PasswordDoesntFollowRequirementsException extends RuntimeException {
    public PasswordDoesntFollowRequirementsException(String message) {
        super(message);
    }
}
