package com.fdapp.auth.application.port.out;

import com.fdapp.auth.domain.User;

import java.util.Optional;

/*
 * Answering the question "WHAT will you be able to do?"
 * */
public interface UserQueryPort {
    boolean existsUserByEmail(String email);
    boolean existsUserByUsername(String username);
    Optional<User> getUserByUserName(String username);
    Optional<User> getUserByEmail(String email);
}
