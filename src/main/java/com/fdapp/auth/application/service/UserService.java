package com.fdapp.auth.application.service;

import com.fdapp.auth.application.dto.UserRegisterCommand;
import com.fdapp.auth.application.dto.UserResult;
import com.fdapp.auth.application.usecase.UserUseCase;
import com.fdapp.auth.domain.port.UserCommandPort;
import com.fdapp.auth.domain.Email;
import com.fdapp.auth.domain.Password;
import com.fdapp.auth.domain.User;
import com.fdapp.auth.domain.service.UserValidator;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService implements UserUseCase {

    private final UserValidator userValidator;
    private final UserCommandPort userCommandPort;

    public UserService(UserValidator userValidator, UserCommandPort userCommandPort) {
        this.userValidator = userValidator;
        this.userCommandPort = userCommandPort;
    }

    @Override
    @Transactional
    public UserResult saveUser(UserRegisterCommand userData) {
        log.info("Checking the user information");
        log.info("Validating business rules");

        userValidator.assertUsernameIsUnique(userData.username());
        userValidator.assertEmailIsUnique(userData.email());

        User userForRepository = new User(userData.username(),
                new Password(userData.password()),
                new Email(userData.email()));

        User userSaved = userCommandPort.saveUser(userForRepository);
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
