package com.fdapp.auth.domain.service;

import com.fdapp.auth.domain.port.UserQueryPort;
import com.fdapp.auth.domain.User;
import com.fdapp.auth.domain.exception.UserDoNotExistByEmail;
import com.fdapp.auth.domain.exception.UserDoNotExistByUserName;
import org.springframework.stereotype.Service;

@Service
public class UserFinder {
    private final UserQueryPort userQueryPort;

    public UserFinder(UserQueryPort userQueryPort) {
        this.userQueryPort = userQueryPort;
    }

    public User mustExistByUserName(String username) {
        return userQueryPort.getUserByUserName(username)
                .orElseThrow(
                        () -> new UserDoNotExistByUserName("User " + username + " doesn't exist")
                );
    }

    public User mustExistByEmail(String email) {
        return userQueryPort.getUserByEmail(email)
                .orElseThrow(
                        () -> new UserDoNotExistByEmail("It doesn't exists an user name related to this email: " + email)
                );

    }

}