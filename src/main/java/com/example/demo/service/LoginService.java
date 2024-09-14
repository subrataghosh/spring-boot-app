package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	private final String USER_ID = "admin@admin.com";
	private final String PASSWORD = "admin";

	public boolean validateUser(String userid, String password) {
		return USER_ID.equals(userid) && PASSWORD.equals(password);
	}

}
