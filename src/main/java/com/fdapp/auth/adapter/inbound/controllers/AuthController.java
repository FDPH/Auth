package com.fdapp.auth.adapter.inbound.controllers;

import com.fdapp.auth.adapter.inbound.dto.request.LoginRequest;
import com.fdapp.auth.adapter.inbound.dto.request.RegisterRequest;
import com.fdapp.auth.application.dto.UserLoginCommand;
import com.fdapp.auth.application.dto.UserRegisterCommand;
import com.fdapp.auth.application.dto.UserResult;
import com.fdapp.auth.application.usecase.LoginUseCase;
import com.fdapp.auth.application.usecase.UserUseCase;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/auth")
public class AuthController {

    private final UserUseCase userUseCase;
    private final LoginUseCase loginUseCase;

    public AuthController(UserUseCase userUseCase, LoginUseCase loginUseCase) {
        this.userUseCase = userUseCase;
        this.loginUseCase = loginUseCase;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResult> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
        log.debug("register resource is running");
        UserRegisterCommand userRegisterCommand = new UserRegisterCommand(registerRequest.username(),registerRequest.email(),registerRequest.password());
        return ResponseEntity.status(HttpStatus.OK).body(userUseCase.saveUser(userRegisterCommand));
    }

    @GetMapping("/login")
    public ResponseEntity<String> registerUser(@RequestBody LoginRequest loginRequest){
        log.debug("login resource is running");
        UserLoginCommand userLoginCommand = new UserLoginCommand(loginRequest.username(),loginRequest.email(), loginRequest.password());
        return ResponseEntity.status(HttpStatus.OK).body(loginUseCase.login(userLoginCommand));
    }

    @GetMapping("/private-hola")
    public ResponseEntity<String> printPrivateHola(){
        log.info("private hola");
        return ResponseEntity.status(HttpStatus.OK).body("private-hola");
    }

    @GetMapping("/public-hola")
    public ResponseEntity<String> printPublicHola(){
       log.info("public hola");
        return ResponseEntity.status(HttpStatus.OK).body("public-hola");
    }
}
