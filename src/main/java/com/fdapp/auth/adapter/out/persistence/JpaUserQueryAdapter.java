package com.fdapp.auth.adapter.out.persistence;

import com.fdapp.auth.adapter.out.persistence.entity.UserEntity;
import com.fdapp.auth.adapter.out.persistence.repository.UserRepository;
import com.fdapp.auth.application.port.out.UserQueryPort;
import com.fdapp.auth.domain.Email;
import com.fdapp.auth.domain.Password;
import com.fdapp.auth.domain.User;

public class JpaUserQueryAdapter implements UserQueryPort {

    private final UserRepository userRepository;

    public JpaUserQueryAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean existsUserByEmail(String email) {
        return userRepository.existsUserByUserEmail(email);
    }

    @Override
    public boolean existsUserByUsername(String username) {
        return userRepository.existsUserByUserName(username);
    }

    @Override
    public User getUserByUserName(String username) {
        UserEntity userByUsername = userRepository.findByUserName(username);
        return new User(userByUsername.getUserName(),
                new Password(userByUsername.getUserPassword()),
                new Email(userByUsername.getUserEmail()));
    }

    @Override
    public User getUserByEmail(String email) {
        UserEntity userByEmail = userRepository.findByUserEmail(email);
        return new User(userByEmail.getUserName(),
                new Password(userByEmail.getUserPassword()),
                new Email(userByEmail.getUserEmail()));
    }
}
