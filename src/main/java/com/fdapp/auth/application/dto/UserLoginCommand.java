package com.fdapp.auth.application.dto;

public record UserLoginCommand(
        String username,
        String email,
        String password) {

}
