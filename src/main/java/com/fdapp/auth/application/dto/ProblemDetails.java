package com.fdapp.auth.application.dto;

import java.net.URI;

public record ProblemDetails(
        URI type,
        String title,
        int status,
        String timestamp,
        String detail
) {
}
