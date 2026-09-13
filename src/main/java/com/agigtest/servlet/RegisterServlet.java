package com.agigtest.servlet;

import java.io.IOException;

import org.mindrot.jbcrypt.BCrypt;

import com.agigtest.config.DatabaseConfig;
import com.agigtest.dao.UserDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
    private UserDAO userDAO;

    @Override 
    public void init() {
        this.userDAO = new UserDAO(DatabaseConfig.getDataSource());
    }

    @Override 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String plainTextPassword = request.getParameter("password");

        String passwordHash = BCrypt.hashpw(plainTextPassword, BCrypt.gensalt(12));
    }
}
