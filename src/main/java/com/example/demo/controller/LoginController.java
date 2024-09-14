package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;

//	private final LoginService loginService;
//
//	public LoginController(LoginService loginService) {
//		this.loginService = loginService;
//	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String showWelcomePage(HttpSession session, ModelMap model, @RequestParam String name, @RequestParam String password){

		boolean isValidUser = loginService.validateUser(name, password);

		if (!isValidUser) {
			model.put("errorMessage", "Invalid Credentials");
			return "login";
		}

		session.setAttribute("isSignedIn", true);

		 return "redirect:/homePage";
	}
	
	@RequestMapping(value = "/homePage", method = RequestMethod.GET)
	public String getHomePage(ModelMap mode) {
		return "home";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut(HttpSession session,ModelMap model) {
		session.removeAttribute("isSignedIn");
		return "redirect:/login";
	}

}
