package edu.project.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomePage_LogIn_MainMenuForAll_LogOut_Controller {
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String showHomePage(){	
		return "home-page";     //the user must click to the href: login in order to go to the login page
	}
	
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogInForAll() {
		
		System.out.println("ready to show: log in page");
		
		return "show-login";
	}

	
	@RequestMapping(value = "/login/main-menu-for-all", method = RequestMethod.POST)
	public String showMainMenuForAll(HttpServletRequest request, Model model, HttpSession session,Authentication auth) {
		System.out.println("ready to show: main menu for all users page");

	
		return "main-menu-for-all";
	}

	
    @RequestMapping(value = "/just-logged-out", method = RequestMethod.GET)
	public String logout(HttpSession session, Model model) {
		session.removeAttribute("username");
		model.addAttribute("log_out_message", "You have just logged out!");
		return "redirect:/login";
	}
}
