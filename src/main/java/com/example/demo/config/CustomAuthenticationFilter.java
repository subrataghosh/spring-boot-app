package com.example.demo.config;

import com.example.demo.service.LoginService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final LoginService authService;

    public CustomAuthenticationFilter(LoginService authService) {
        this.authService = authService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String username = request.getParameter("name");
        String password = request.getParameter("password");

        if (authService.validateUser(username, password)) {
            return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>()); // No authorities
        } else {
            throw new BadCredentialsException("Invalid credentials");
        }
    }
}
