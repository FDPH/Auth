package com.fdapp.auth.adapter.out.persistence;

import com.fdapp.auth.adapter.out.persistence.repository.UserRepository;
import com.fdapp.auth.domain.port.UserQueryPort;
import com.fdapp.auth.domain.Email;
import com.fdapp.auth.domain.Password;
import com.fdapp.auth.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
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
    public Optional<User> getUserByUserName(String username) {
        return userRepository.findByUserName(username).map(
                userEntity -> new User(userEntity.getUserName(),
                        new Password(userEntity.getUserPassword()),
                        new Email(userEntity.getUserEmail()))
        );
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByUserEmail(email).map(userEntity ->
                new User(userEntity.getUserName(),
                        new Password(userEntity.getUserPassword()),
                        new Email(userEntity.getUserEmail())));
    }
}
