package edu.project.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import edu.project.entity.Users;


@RestController
@RequestMapping("/api")
public class RestControllers {

	//CREATE USERS 
	@RequestMapping(value = "/user", method = RequestMethod.POST, produces = "application/json",  consumes = "application/json")
    public Users addUser(@RequestBody Users user) {
		System.out.println("Education: REST: creation of new user ");
            
    /*       sample data (raw-application/json)
            {
            		"username": "Alekos",
            		"password": "Alekos",
                    "fname": "Alekos",
                    "lname": "Sakellarios",
                    "sex": "male",
                    "email": "alekos@hua.gr",
                    "phone": "2102534712",
                    "role": "alekos@hua.gr",
                    "points": 3
            }
    */
                       
          //save the user in the database 
    	
    	
    	 //after the new user was successful saved in the database, return the user             
            return user;
    }
	
	
	//LOGIN 
	@RequestMapping(value = "/login/menu/{username}", method = RequestMethod.GET, produces = "application/json",  consumes = "application/json")
	public @ResponseBody Users showMenu(HttpServletRequest request, @PathVariable String username) {
		System.out.println("Education: ready to show: menu page");

		Users user = new Users();
		
		//the external app sends username
		
		//retrieve from the database the password and then send it to the external 
		
	   // returns object type of Users, which contains the username and the password
		return user;
	}
	
	
	
	//MENU --> OPTIONS --> RESULTS 
	//PROJECTS
	@RequestMapping(value = "/login/menu/projects", method = RequestMethod.GET, produces = "application/json",  consumes = "application/json")
	public List<> returnprojects(HttpServletRequest request, @PathVariable String username) {
		System.out.println("Education: ready to show: menu page");
		
		private List<> theProjects;
		
		//the external app sends username
		
		//retrieve from the database the projects and then send them to the external 
		
	   // returns object type of Users, which contains the username and the password
		return theProjects;
	}
	
	
	//QUIZES 
	@RequestMapping(value = "/login/menu/quizes", method = RequestMethod.GET, produces = "application/json",  consumes = "application/json")
	public List<> returnquizes(HttpServletRequest request, @PathVariable String username) {
		System.out.println("Education: ready to show: menu page");
		
		private List<> theQuizes;
		
		//the external app sends username
		
		//retrieve from the database the quizes and then send them to the external 
		
	   // returns the list with the quizes
		return theQuizes;
	}
	
	//READINGS 
	@RequestMapping(value = "/login/menu/readings", method = RequestMethod.GET, produces = "application/json",  consumes = "application/json")
	public List<> returnReadings(HttpServletRequest request, @PathVariable String username) {
		System.out.println("Education: ready to show: menu page");
		
		private List<> theQuizes;
		
		//the external app sends username
		
		//retrieve from the database the projects and then send them to the external 
		
	   //  returns the list with the
		return theQuizes;
	}
	

	//CRAFTS
	@RequestMapping(value = "/login/menu/crafts", method = RequestMethod.GET, produces = "application/json",  consumes = "application/json")
	public List<> returnCrafts(HttpServletRequest request, @PathVariable String username) {
		System.out.println("Education: ready to show: menu page");
		
		private List<> theReadings;
		
		//the external app sends username
		
		//retrieve from the database the projects and then send them to the external 
		
	   // returns the list with the
		return theReadings;
	}
	
	//ANNOUNCEMENTS 
	@RequestMapping(value = "/login/menu/announcements", method = RequestMethod.GET, produces = "application/json",  consumes = "application/json")
	public List<> returnAnnouncements(HttpServletRequest request, @PathVariable String username) {
		System.out.println("Education: ready to show: menu page");
		
		private List<> theAnnouncements;
		
		//the external app sends username
		
		//retrieve from the database the projects and then send them to the external 
		
	   //  returns the list with the
		return theAnnouncements;
	}
	
	
	
	
}
