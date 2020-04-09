package edu.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mongodb.client.MongoDatabase;

@Controller
public class EduControllers {

	
	@RequestMapping(value = "/",method = RequestMethod.GET )
	public String showRoot(){
		return "home-page";
	}

	
	@RequestMapping(value = "/home-page",method = RequestMethod.GET )
	public String showEmployeeLogIn(){
		return "home-page";
	}
	

}