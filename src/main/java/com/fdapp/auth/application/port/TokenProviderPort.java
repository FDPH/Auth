package com.fdapp.auth.application.port;

public interface TokenProviderPort {
    String generateToken(String userName);
}
