package com.fdapp.auth.application.port.out;

import com.fdapp.auth.domain.User;

public interface UserQueryPort {
    boolean existsUserByEmail(String email);
    boolean existsUserByUsername(String username);
    User getUserByUserName(String username);
    User getUserByEmail(String email);
}
