package com.agigtest.servlet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloServet", urlPatterns = {"/api/hello"})
public class HelloServlet extends HttpServlet {
    @Override 
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        if (name == null || name.isBlank()) {
            name = "World";
        }

        PrintWriter out = resp.getWriter();
        out.print("{\"status\":\"success\",\"message\":\"Hello, " + name + "! Handled by pure Java Servlet.\"}");
        out.flush();
    }

    @Override 
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        StringBuilder body = new StringBuilder();
        try (BufferedReader reader = req.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                body.append(line);
            }
        }

        PrintWriter out = resp.getWriter();
        out.print("{\"status\":\"received\",\"receivedPayload\":" + (body.length() > 0 ? body.toString() : "\"{}\"") + "}");
        out.flush();
    }
}

