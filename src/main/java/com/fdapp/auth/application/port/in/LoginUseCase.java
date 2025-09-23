package com.fdapp.auth.application.port.in;

import com.fdapp.auth.application.dto.UserLoginCommand;

public interface LoginUseCase {
   String login(UserLoginCommand userLoginCommand);
}