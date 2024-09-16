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
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String showLoginPage(HttpSession session) {
		Boolean isSignedIn = (Boolean) session.getAttribute("isSignedIn");
		boolean isSignedInBoolean = (isSignedIn != null && isSignedIn);
		System.out.println(isSignedInBoolean);
		return isSignedInBoolean ? "redirect:/homePage" : "login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String showWelcomePage(HttpSession session, ModelMap model, @RequestParam String name, @RequestParam String password){

		boolean isValidUser = loginService.validateUser(name, password);
		System.out.println("Is valid user: " + isValidUser);

		if (!isValidUser) {
			model.put("errorMessage", "Invalid Credentials");
			return "login";
		}

		session.setAttribute("isSignedIn", true);
		System.out.println("Session ID after login: " + session.getId());
		System.out.println("isSignedIn after login: " + session.getAttribute("isSignedIn"));

		 return "redirect:/homePage";
	}
	
	@RequestMapping(value = "/homePage", method = RequestMethod.GET)
	public String getHomePage(HttpSession session, ModelMap mode) {
		System.out.println("Session ID on home: " + session.getId());
		System.out.println("isSignedIn on home: " + session.getAttribute("isSignedIn"));
		return "home";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut(HttpSession session,ModelMap model) {
		session.removeAttribute("isSignedIn");
		return "redirect:/login";
	}

}
