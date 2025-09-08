package com.fdapp.auth.adapter.inbound.dto.request;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
        @NotBlank(message = "The username cannot be empty or null")
        String username,
        @NotBlank(message = "Password field can't be empty or null")
        String password
) {
}
