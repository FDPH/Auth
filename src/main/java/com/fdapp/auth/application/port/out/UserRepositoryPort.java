package com.fdapp.auth.application.port.out;

import com.fdapp.auth.domain.User;

/*
* Answering the question "WHAT will you be able to do?"
* */
public interface UserRepositoryPort {
    boolean existsUserByEmail(String email);
    boolean existsUserByUsername(String username);
    User getUserByUserName(String username);
    User getUserByEmail(String email);
    User saveUser(User user);
    void deleteUser(User user);
    User updateUserParameters(User user);
}
