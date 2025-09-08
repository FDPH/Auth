package com.fdapp.auth.domain;

import com.fdapp.auth.domain.exception.PasswordException;

public record Password(String value) {
    public Password {
        if (value == null || value.length() < 8) {
            throw new PasswordException("Password must have at least 8 characters");
        }
        if (!value.matches(".*[A-Z].*")) {
            throw new PasswordException("Password must contain an uppercase letter");
        }
        if (!value.matches(".*[a-z].*")) {
            throw new PasswordException("Password must contain a lowercase letter");
        }
        if (!value.matches(".*\\d.*")) {
            throw new PasswordException("Password must contain a digit");
        }
    }
}
