package com.fdapp.auth.adapter.out.persistence;

import com.fdapp.auth.adapter.out.persistence.entity.UserEntity;
import com.fdapp.auth.adapter.out.persistence.repository.UserRepository;
import com.fdapp.auth.application.port.out.UserRepositoryPort;
import com.fdapp.auth.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public class JpaUserRegisterRepositoryAdapter implements UserRepositoryPort {

    private final UserRepository userRepository;

    public JpaUserRegisterRepositoryAdapter(UserRepository userRepository) {
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
        return new User(userByUsername.getUserName(), userByUsername.getUserPassword(), userByUsername.getUserEmail());
    }

    @Override
    public User getUserByEmail(String email) {
        UserEntity userByEmail = userRepository.findByUserEmail(email);
        return new User(userByEmail.getUserName(), userByEmail.getUserPassword(), userByEmail.getUserEmail());
    }

    @Override
    public User saveUser(User user) {
        UserEntity save = userRepository.save(new UserEntity(user.getUsername(), user.getPassword(), user.getEmail()));
        return new User(save.getUserName(), save.getUserPassword(), save.getUserEmail());
    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public User updateUserParameters(User user) {
        return null;
    }
}
