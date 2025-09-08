package com.fdapp.auth.adapter.inbound.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterRequest(
        @NotBlank(message = "The username cannot be empty or null")
        String username,
        @NotBlank(message = "Password field can't be empty or null")
        String password,
        @NotNull(message = "email field can't be empty or null")
        @Email(message = "Validate the email format")
        String email
) {
}
