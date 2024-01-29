package com.example.servlet;

import com.example.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getAttribute("user") == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("user/hello.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (login == null || login.isEmpty() || password == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        if (Users.getInstance().getUsers().contains(login)) {
            request.setAttribute("user", login);
            request.getRequestDispatcher("user/hello.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
