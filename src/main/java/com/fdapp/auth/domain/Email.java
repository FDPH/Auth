package com.fdapp.auth.domain;

import com.fdapp.auth.domain.exception.EmailException;

public record Email(String value) {
    public Email {
        if (value == null || value.trim().isEmpty()) {
            throw new EmailException("Email can't be empty");
        }
        if (!value.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new EmailException("Invalid email format");
        }
    }
}