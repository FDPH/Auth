package com.fdapp.auth.domain.service;

import com.fdapp.auth.domain.User;
import com.fdapp.auth.domain.exception.PasswordIsIncorrectException;
import org.springframework.stereotype.Service;

@Service
public class PasswordValidator {

    public void assertPasswordIsCorrect(User user, String inPassword) {
        if (user.getPassword().equals(inPassword)){
            throw new PasswordIsIncorrectException("User password doesn't match");
        }
    }
}
