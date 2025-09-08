package com.fdapp.auth.application.dto;

public record UserRegisterCommand(
        String username,
        String email,
        String password) {
}
