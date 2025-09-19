package com.fdapp.auth.application.port.out;

import com.fdapp.auth.domain.User;

public interface UserCommandPort {
    User saveUser(User user);
    void deleteUser(User user);
    User updateUserParameters(User user);
}
