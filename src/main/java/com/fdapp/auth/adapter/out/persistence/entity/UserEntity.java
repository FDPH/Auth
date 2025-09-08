package com.fdapp.auth.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(name = "user_name", nullable = false, unique = true, length = 50)
    private String userName;

    @Setter
    @Column(name = "user_password", nullable = false)
    private String userPassword;

    @Setter
    @Column(name = "user_email", unique = true, length = 50)
    private String userEmail;

    @Setter
    @Column(name = "enabled", nullable = false)
    private boolean enabled = true;

    @CreationTimestamp
    @Column(name = "creation_dt", nullable = false)
    private LocalDateTime creationDt;

    public UserEntity(String userName, String userPassword, String userEmail) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
    }
}