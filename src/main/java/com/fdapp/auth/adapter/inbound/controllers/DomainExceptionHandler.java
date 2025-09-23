package com.fdapp.auth.adapter.inbound.controllers;

import com.fdapp.auth.domain.exception.UserAlreadyExistsException;
import com.fdapp.auth.domain.exception.UserDoNotExistByUserName;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;

@RestControllerAdvice
@Slf4j
public class DomainExceptionHandler {

    @ExceptionHandler(UserDoNotExistByUserName.class)
    public ResponseEntity<ProblemDetail> handleUserAlreadyExistsException(UserDoNotExistByUserName userDoNotExistByUserName) {
        log.error(userDoNotExistByUserName.getMessage(), userDoNotExistByUserName);
        ProblemDetail problemDetail =
                ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        problemDetail.setTitle("User do not exist");
        problemDetail.setType(URI.create("https://fdpapp.com/docs/errors/user-do-not-exist"));
        problemDetail.setDetail(userDoNotExistByUserName.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problemDetail);
    }
}
