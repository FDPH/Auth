package com.fdapp.auth.application.dto;

public record UserRegisteredResult(
        String userName,
        String email,
        String token,
        boolean isSave
) {
}
