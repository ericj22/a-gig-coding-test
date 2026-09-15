package com.agigtest.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter 
public class User {
    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String passwordHash;
    private LocalDateTime createdAt;

    public User(String username, String email, String firstName, String lastName, String passwordHash) {
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passwordHash = passwordHash;
    }
}
