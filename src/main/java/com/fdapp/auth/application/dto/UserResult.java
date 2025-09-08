package com.fdapp.auth.application.dto;

public record UserResult(
        String userName,
        String email,
        String token,
        boolean isSave
) {
}
