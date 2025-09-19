package com.fdapp.auth.application.port.in;

public interface LoginUseCase {
    public boolean isPasswordCorrect(String userName, String password);
}