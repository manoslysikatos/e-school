package edu.project.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import javax.servlet.http.HttpSession;

import edu.project.entity.*;
import net.bytebuddy.implementation.bind.annotation.AllArguments.Assignment;
import edu.project.database.*;


@RestController 
@RequestMapping("/api")                           
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RestControllers {
	
	// inject the DAO
	@Autowired
	private DAO DAO;

	private MongoDatabase mongodb;
	
	private FindIterable<Document> user_result;

	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello() {
		return "Hello";
	}
            
            
	//CREATE USERS 
	@RequestMapping(value = "/user", method = RequestMethod.POST, produces = "application/json")    //DEN LEITOYRGEI --WE DO NOT NEED IT FOR NOW  
    public Users addUser() {    //@RequestBody Users user
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
                    "role": "teacher",
                    "points": 3
            }
    */
		Users user = new Users("Alekos", "Alekos", "Alekos","Sakellarios", "male", "alekos@hua.gr", "2102534712", "teacher", 3);  
          
          
          //save the user in the database 
             	
    	 //after the new user was successful saved in the database, return the user             
          return user;       
    }
	
	
	//AFTER THE  LOGIN ( WHEN IT WILL WORK ), ME TO POY FORTWNEI TO MENU , RETURNS USER THAT CONTAINS A LIST WITH THE  classes   
	@RequestMapping(value = "/login/menu/{username}", method = RequestMethod.GET) //, produces = "application/json" )
	public @ResponseBody String showMenu(@PathVariable String username, HttpSession session) {  
		System.out.println("Education: ready to show: menu page");

		//the external app sends the username
		//retrieve from the database the password and then send it to the external 
		mongodb = DAO.connect_to_database();
		session.setAttribute("student's_username", username);    //add username in session 
		String user = DAO.find_user(mongodb, username); 	   // returns string, which contains contains a json
		return user;
	}

	//STUDENTS: MENU --> OPTIONS --> RESULTS 
	//PROJECTS  -- ASSIGNMENTS
	@RequestMapping(value = "/login/menu/projects", method = RequestMethod.GET)   
	public @ResponseBody String returnAssignments(HttpSession session) {
		System.out.println("Education: ready to show: menu page");
					
		//retrieve from the database the projects and then send them to the external 
		mongodb = DAO.connect_to_database();
		//retrieve from database all the assignments for the user/student and return them 
		List <String>  Assignments = DAO.find_Assignments_for_a_student(mongodb, session) ;    
		return Assignments.toString();
	}
	
	
	//QUIZES 
	@RequestMapping(value = "/login/menu/quizes", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String returnquizes(HttpSession session) { 
		System.out.println("Education: ready to show: menu page");
	
		//retrieve from the database the quizes and then send them to the external 
	    mongodb = DAO.connect_to_database();
		//retrieve from database all the assignments for the user/student and return them 
        List <String>  theQuizes = DAO.find_Quizes_for_a_student(mongodb, session);
				
		return theQuizes.toString();
	}
	
//	//READINGS 
//	@RequestMapping(value = "/login/menu/readings", method = RequestMethod.GET, produces = "application/json",  consumes = "application/json")
//	public List<> returnReadings(HttpServletRequest request) {
//		System.out.println("Education: ready to show: menu page");
//		
//		private List<> theQuizes;
//		
//		//retrieve from the database the projects and then send them to the external 
//		
//	   //  returns the list with the
//		return theQuizes;
//	}
//	
//
//	//CRAFTS
//	@RequestMapping(value = "/login/menu/crafts", method = RequestMethod.GET, produces = "application/json",  consumes = "application/json")
//	public List<> returnCrafts(HttpServletRequest request) {
//		System.out.println("Education: ready to show: menu page");
//		
//		private List<> theReadings;
//		
//		//retrieve from the database the projects and then send them to the external 
//		
//	   // returns the list with the
//		return theReadings;
//	}
//	
//	//ANNOUNCEMENTS 
//	@RequestMapping(value = "/login/menu/announcements", method = RequestMethod.GET, produces = "application/json",  consumes = "application/json")
//	public List<> returnAnnouncements(HttpServletRequest request) {
//		System.out.println("Education: ready to show: menu page");
//		
//		private List<> theAnnouncements   ;
//		
//		//retrieve from the database the projects and then send them to the external 
//		
//	   //  returns the list with the
//		return theAnnouncements;
//	}
	
	
	
	
}
