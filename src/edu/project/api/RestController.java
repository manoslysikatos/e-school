package edu.project.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class RestController {
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showHomePage() {
		System.out.println("ready to show: home page");

		String json = "{\"Title\": \"This is the home-page\"}";
		return json;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogInForAll() {
		System.out.println("ready to show: log in page");

		return "This is the login-page";
	}
	
	
	@RequestMapping(value = "/login/main-menu-for-all", method = RequestMethod.GET, produces = "application/json",  consumes = "application/json")
	public @ResponseBody Users showMainMenuForAll(HttpServletRequest request, Model model, HttpSession session) {
		System.out.println("DS: ready to show: main menu for all users page");

		//external sends username, retrieve form the database the password and then send it to the external 
	 // returns object type of Users, which contains the username and the department
		return user;
	}

}
