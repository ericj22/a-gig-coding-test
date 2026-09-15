package com.agigtest.service;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;

import com.agigtest.config.DatabaseConfig;
import com.agigtest.dao.UserDAO;
import com.agigtest.exceptions.DuplicateEmailException;
import com.agigtest.exceptions.DuplicateUsernameException;
import com.agigtest.model.User;

public class UserService {
    private final UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO(DatabaseConfig.getDataSource());
    }

    public boolean register(String username, String email, String firstName, String lastName, String plainPassword) throws RuntimeException {
        String passwordHash = BCrypt.hashpw(plainPassword, BCrypt.gensalt(12));

        if (userDAO.existsByUsername(username)) {
            throw new DuplicateUsernameException("The username '" + username + "' is already in use.");
        }
        if (userDAO.existsByEmail(email)) {
            throw new DuplicateEmailException("The email '" + email + "' is already in use.");
        }

        return userDAO.register(
            username, 
            email, 
            passwordHash, 
            firstName,
            lastName
        );
    }
    
    public Optional<User> authenticate(String username, String plainPassword) {
        if (username == null || plainPassword == null) return Optional.empty();

        Optional<User> optUser = userDAO.getByUsername(username);

        if (optUser.isPresent()) {
            User user = optUser.get();
            if (BCrypt.checkpw(plainPassword, user.getPasswordHash())) {
                user.setPasswordHash(null);
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
}
