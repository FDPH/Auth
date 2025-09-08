package com.fdapp.auth.application.service;

import com.fdapp.auth.application.dto.UserRegisterCommand;
import com.fdapp.auth.application.dto.UserResult;
import com.fdapp.auth.application.exception.UserAlreadyExistsException;
import com.fdapp.auth.application.port.in.UserUseCase;
import com.fdapp.auth.application.port.out.TokenProviderPort;
import com.fdapp.auth.application.port.out.UserRepositoryPort;
import com.fdapp.auth.domain.Email;
import com.fdapp.auth.domain.Password;
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
    public UserResult saveUser(UserRegisterCommand userData) {
        log.info("Checking the user information");

        User userForRepository = new User(userData.username(),
                new Password(userData.password()),
                new Email(userData.email()));

        if (userRepositoryPort.existsUserByUsername(userData.username())
                || userRepositoryPort.existsUserByEmail(userData.email())) {
            log.info("User {} or email {} already exists", userData.username(), userData.email());
            throw new UserAlreadyExistsException("The username or email already exists in our system");
        }

        User userSaved = userRepositoryPort.saveUser(userForRepository);
        log.info("User registered successfully");
        return new UserResult(userSaved.getUsername(), userSaved.getEmail().value(), "123", true);
    }

    @Override
    public UserResult getUserByEmail(String email) {
        return null;
    }

    @Override
    public UserResult getUserByUserName(String email) {
        return null;
    }

    @Override
    public void softDeleteUserByUserName(String username) {

    }
}
