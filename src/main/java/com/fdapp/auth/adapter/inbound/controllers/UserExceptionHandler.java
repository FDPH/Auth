package com.fdapp.auth.adapter.inbound.controllers;

import com.fdapp.auth.application.exception.UserAlreadyExistsException;
import com.fdapp.auth.domain.exception.EmailException;
import com.fdapp.auth.domain.exception.PasswordException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;
import java.util.Map;

@RestControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ProblemDetail> handleUserAlreadyExistsException(UserAlreadyExistsException userAlreadyExistsException) {
        ProblemDetail problemDetail =
                ProblemDetail.forStatus(HttpStatus.CONFLICT);
        problemDetail.setTitle("User Already Exists");
        problemDetail.setType(URI.create("https://fdpapp.com/docs/errors/user-already-exist"));
        problemDetail.setDetail(userAlreadyExistsException.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(problemDetail);
    }

    @ExceptionHandler(EmailException.class)
    public ResponseEntity<ProblemDetail> handleEmailException(EmailException emailException) {
        ProblemDetail problemDetail =
                ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problemDetail.setTitle("Email is not valid");
        problemDetail.setType(URI.create("https://fdpapp.com/docs/errors/email-format-exception"));
        problemDetail.setDetail(emailException.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problemDetail);
    }

    @ExceptionHandler(PasswordException.class)
    public ResponseEntity<ProblemDetail> handlePasswordException(PasswordException passwordException) {
        ProblemDetail problemDetail =
                ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problemDetail.setTitle("Password is not valid");
        problemDetail.setType(URI.create("https://fdpapp.com/docs/errors/password-security-exception"));
        problemDetail.setProperties(Map.of("Error code", "1234"));
        problemDetail.setDetail(passwordException.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problemDetail);
    }

}
