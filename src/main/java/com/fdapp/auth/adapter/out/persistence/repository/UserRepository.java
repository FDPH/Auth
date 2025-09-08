package com.fdapp.auth.adapter.out.persistence.repository;

import com.fdapp.auth.adapter.out.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsUserByUserName(String username);
    boolean existsUserByUserEmail(String email);
    UserEntity findByUserName(String userName);
    UserEntity findByUserEmail(String email);
}
