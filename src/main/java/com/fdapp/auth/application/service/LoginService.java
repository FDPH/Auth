package com.fdapp.auth.application.service;

import com.fdapp.auth.application.dto.UserLoginCommand;
import com.fdapp.auth.application.port.in.LoginUseCase;
import com.fdapp.auth.application.port.out.TokenProviderPort;
import com.fdapp.auth.domain.User;
import com.fdapp.auth.domain.service.PasswordValidator;
import com.fdapp.auth.domain.service.UserFinder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginService implements LoginUseCase {

    private final UserFinder userFinder;
    private final PasswordValidator passwordValidator;
    private final TokenProviderPort tokenProviderPort;


    public LoginService(UserFinder userFinder, PasswordValidator passwordValidator, TokenProviderPort tokenProviderPort) {
        this.userFinder = userFinder;
        this.passwordValidator = passwordValidator;
        this.tokenProviderPort = tokenProviderPort;
    }

    @Override
    public String login(UserLoginCommand userLoginCommand) {
        User userInSystem = userFinder.mustExistByUserName(userLoginCommand.username());
        passwordValidator.assertPasswordIsCorrect(userInSystem,userLoginCommand.password());
        return tokenProviderPort.generateToken(userLoginCommand.username());
    }

}
