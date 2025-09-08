package com.fdapp.auth.adapter.inbound.controllers;

import com.fdapp.auth.adapter.inbound.dto.request.LoginRequest;
import com.fdapp.auth.adapter.inbound.dto.request.RegisterRequest;
import com.fdapp.auth.application.dto.UserRegisterCommand;
import com.fdapp.auth.application.port.in.UserUseCase;
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

    public AuthController(UserUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
        log.debug("register resource is running");
        UserRegisterCommand userRegisterCommand = new UserRegisterCommand(registerRequest.username(),registerRequest.email(),registerRequest.password());
        userUseCase.saveUser(userRegisterCommand);
        return ResponseEntity.status(HttpStatus.OK).body("aqui estamos");
    }

    @GetMapping("/Login")
    public ResponseEntity<String> registerUser(@RequestBody LoginRequest loginRequest){
        System.out.println("aqui estamos");
        return ResponseEntity.status(HttpStatus.OK).body("aqui estamos");
    }

    @GetMapping("/private-hola")
    public ResponseEntity<String> printPrivateHola(){
        System.out.println("private-hola");
        return ResponseEntity.status(HttpStatus.OK).body("private-hola");
    }

    @GetMapping("/public-hola")
    public ResponseEntity<String> printPublicHola(){
        System.out.println("public-hola");
        return ResponseEntity.status(HttpStatus.OK).body("public-hola");
    }
}
