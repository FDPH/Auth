package com.fdapp.auth.application.usecase;

import com.fdapp.auth.application.dto.UserLoginCommand;

public interface LoginUseCase {
   String login(UserLoginCommand userLoginCommand);
}