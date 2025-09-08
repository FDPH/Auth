package com.fdapp.auth.application.port.in;

import com.fdapp.auth.application.dto.UserRegisterCommand;
import com.fdapp.auth.application.dto.UserResult;

public interface UserUseCase {
    UserResult saveUser(UserRegisterCommand userData);
    UserResult getUserByEmail(String email);
    UserResult getUserByUserName(String email);
    void softDeleteUserByUserName(String username);
}
