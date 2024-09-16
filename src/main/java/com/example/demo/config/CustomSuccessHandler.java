package com.example.demo.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CustomSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        // Redirect to /homePage on successful login
        System.out.println("Authentication succeeded, redirecting to /homePage");
        HttpSession session = request.getSession();

        // Set session attributes here
        session.setAttribute("isSignedIn", true);

        // Redirect to the home page after setting session attributes
        response.sendRedirect("/homePage");
    }
}
