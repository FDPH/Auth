package com.fdapp.auth.application.port.out;

import com.fdapp.auth.domain.User;

public interface TokenProviderPort {
    String createToken(User user);
}
