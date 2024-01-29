package com.example.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = {
        "/user/*"
})
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String userParam = request.getAttribute("user").toString();
        if (userParam == null || userParam.isEmpty()) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}