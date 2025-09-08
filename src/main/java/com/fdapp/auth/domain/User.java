package com.fdapp.auth.domain;

import com.fdapp.auth.domain.exception.UserValuesException;

public class User {
    private final String username;
    private final Password password;
    private final Email email;

    public User(String username, Password password, Email email) {
        this.username = validateUserName(username);
        this.password = password;
        this.email = email;
    }

    private String validateUserName(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new UserValuesException("username can't be empty or null");
        }
        return username;
    }

    public String getUsername() {
        return username;
    }

    public Password getPassword() {
        return password;
    }

    public Email getEmail() {
        return email;
    }
}
