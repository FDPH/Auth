package com.fdapp.auth.application.port.in;

import com.fdapp.auth.application.dto.UserRegisterCommand;
import com.fdapp.auth.application.dto.UserRegisteredResult;

public interface UserUseCase {
    UserRegisteredResult saveUser(UserRegisterCommand userData);
}
