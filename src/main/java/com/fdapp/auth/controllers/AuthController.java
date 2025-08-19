package com.fdapp.auth.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/token")
    private ResponseEntity<String> createJwt(){
        System.out.println("aqui estamos");
        return ResponseEntity.status(HttpStatus.OK).body("aqui estamos");
    }
}
