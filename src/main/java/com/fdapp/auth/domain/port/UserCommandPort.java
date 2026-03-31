package com.fdapp.auth.domain.port;

import com.fdapp.auth.domain.User;

/*
 * Answering the question "WHAT do you need to do your core tasks"
 * */

public interface UserCommandPort {
    User saveUser(User user);
    void deleteUser(User user);
    User updateUserParameters(User user);
}
