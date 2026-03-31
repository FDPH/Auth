package com.fdapp.auth.domain.port;

import com.fdapp.auth.domain.User;

import java.util.Optional;

/*
 * Answering the question "WHAT do you need to do your core tasks"
 * */
public interface UserQueryPort {
    boolean existsUserByEmail(String email);
    boolean existsUserByUsername(String username);
    Optional<User> getUserByUserName(String username);
    Optional<User> getUserByEmail(String email);
}
