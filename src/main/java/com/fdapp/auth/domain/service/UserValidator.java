package com.fdapp.auth.domain.service;

import com.fdapp.auth.application.port.out.UserQueryPort;
import com.fdapp.auth.domain.exception.EmailAlreadyUsedException;
import com.fdapp.auth.domain.exception.UserAlreadyExistsException;
import org.springframework.stereotype.Service;

@Service
public class UserValidator {

    private final UserQueryPort userQueryPort;

    public UserValidator(UserQueryPort userQueryPort) {
        this.userQueryPort = userQueryPort;
    }

    public void assertEmailIsUnique(String email) {
        if (userQueryPort.existsUserByEmail(email)) {
            throw new EmailAlreadyUsedException("Email is already used");
        }
    }

    public void assertUsernameIsUnique(String username) {
        if (userQueryPort.existsUserByUsername(username)) {
            throw new UserAlreadyExistsException("User name: " + username + " have been already use");
        }
    }

}
