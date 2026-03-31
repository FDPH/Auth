package com.fdapp.auth.adapter.out.external;

import com.fdapp.auth.application.port.TokenProviderPort;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class TokenProviderAdapter implements TokenProviderPort {

    private final Key key;
    private final long expiration;

    public TokenProviderAdapter(@Value("${jwt.secret}") String secret,
                                @Value("${jwt.expiration}") long expiration) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.expiration = expiration;
    }

    @Override
    public String generateToken(String userName) {

        return Jwts.builder()
                .setSubject(userName)
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

}
