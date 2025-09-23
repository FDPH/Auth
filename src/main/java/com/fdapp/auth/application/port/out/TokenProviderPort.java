package com.fdapp.auth.application.port.out;

public interface TokenProviderPort {
    String generateToken(String userName);
}
