package com.fdapp.auth.adapter.out.persistence.repository;

import com.fdapp.auth.adapter.out.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsUserByUserName(String username);
    boolean existsUserByUserEmail(String email);
    Optional<UserEntity> findByUserName(String userName);
    Optional<UserEntity> findByUserEmail(String email);
}
