package com.fdapp.auth.application.service;

import com.fdapp.auth.application.dto.UserRegisterCommand;
import com.fdapp.auth.application.dto.UserRegisteredResult;
import com.fdapp.auth.application.exception.UserAlreadyExistsException;
import com.fdapp.auth.application.port.in.UserUseCase;
import com.fdapp.auth.application.port.out.TokenProviderPort;
import com.fdapp.auth.application.port.out.UserRepositoryPort;
import com.fdapp.auth.domain.User;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService implements UserUseCase {

    private final UserRepositoryPort userRepositoryPort;
    private final TokenProviderPort tokenProviderPort;

    public UserService(UserRepositoryPort userRepositoryPort, TokenProviderPort tokenProviderPort) {
        this.userRepositoryPort = userRepositoryPort;
        this.tokenProviderPort = tokenProviderPort;
    }

    @Override
    @Transactional
    public UserRegisteredResult saveUser(UserRegisterCommand userData) {
        log.info("Checking the user information");
        User user = new User(userData.username(), userData.password(), userData.email());
        if (userRepositoryPort.existsUserByUsername(userData.username())
                || userRepositoryPort.existsUserByEmail(userData.email())) {
            throw new UserAlreadyExistsException("User already exists in our system");
        }

        user = userRepositoryPort.saveUser(user);
        log.info("User registered successfully");


        return null;
    }
}
