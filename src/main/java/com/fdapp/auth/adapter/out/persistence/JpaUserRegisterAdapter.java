package com.fdapp.auth.adapter.out.persistence;

import com.fdapp.auth.adapter.out.persistence.entity.UserEntity;
import com.fdapp.auth.adapter.out.persistence.repository.UserRepository;
import com.fdapp.auth.domain.port.UserCommandPort;
import com.fdapp.auth.domain.Email;
import com.fdapp.auth.domain.Password;
import com.fdapp.auth.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public class JpaUserRegisterAdapter implements UserCommandPort {

    private final UserRepository userRepository;

    public JpaUserRegisterAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        UserEntity save = userRepository.save(new UserEntity(user.getUsername(),
                user.getPassword().value(),
                user.getEmail().value()));

        return new User(save.getUserName(),
                new Password(save.getUserPassword()),
                new Email(save.getUserEmail()));
    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public User updateUserParameters(User user) {
        return null;
    }
}
