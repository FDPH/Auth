package com.fdapp.auth.adapter.out.external;

import com.fdapp.auth.application.port.out.TokenProviderPort;
import com.fdapp.auth.domain.User;
import org.springframework.stereotype.Component;

@Component
public class TokenProviderAdapter implements TokenProviderPort {
    @Override
    public String createToken(User user) {

        return "";
    }
}
