package com.fdapp.auth.application.usecase;

import com.fdapp.auth.application.dto.UserRegisterCommand;
import com.fdapp.auth.application.dto.UserResult;

public interface UserUseCase {
    UserResult saveUser(UserRegisterCommand userData);
    UserResult getUserByEmail(String email);
    UserResult getUserByUserName(String username);
    void softDeleteUserByUserName(String username);
}
