package com.fdapp.auth.application.service;

import com.fdapp.auth.application.port.in.LoginUseCase;

public class LoginService implements LoginUseCase {
    @Override
    public boolean isPasswordCorrect(String userName, String password) {
        return false;
    }
}
