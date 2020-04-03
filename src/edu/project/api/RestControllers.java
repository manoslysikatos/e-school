package edu.project.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import edu.project.entity.*;


@RestController
@RequestMapping("/api")
public class RestControllers {

	//CREATE USERS 
	@RequestMapping(value = "/user", method = RequestMethod.POST, produces = "application/json",  consumes = "application/json")
    public  Users addUser(@RequestBody Users user) {
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
          user= new Users("Alekos", "Alekos", "Alekos","Sakellarios", "male", "alekos@hua.gr", "2102534712", "teacher", 3);  
          
          
          //save the user in the database 
             	
    	 //after the new user was successful saved in the database, return the user             
          return user;
            
            
    }
	
	
	//LOGIN 
	@RequestMapping(value = "/login/menu/{username}", method = RequestMethod.GET, produces = "application/json",  consumes = "application/json")
	public @ResponseBody Users showMenu(HttpServletRequest request, @PathVariable String username) {
		System.out.println("Education: ready to show: menu page");

		Users user= new Users("Alekos", "Alekos", "Alekos","Sakellarios", "male", "alekos@hua.gr", "2102534712", "teacher", 3); 
		
		//the external app sends username
		
		//retrieve from the database the password and then send it to the external 
		
	   // returns object type of Users, which contains the username and the password
		return user;
	}
	
	
	//ME TO POY FORTWNEI TO MENU , MIA LISTA me classes 
		@RequestMapping(value = "/login/menu/information/{username}", method = RequestMethod.GET,  consumes = "application/json")
		public String classList (HttpServletRequest request, @PathVariable String username) {
			System.out.println("Education: ready to show: menu page");

			
			//the external sends the username and i find in the database 
			
			
			
           //SEND TO THE EXTERNAL JSON WHICH  contains the list with the classes 
	       String json = "[{\"subject\" : \"Maths\", \"teacher\": \"Malvinaki Vamvakari\", \"students\": [\"Mary\" , \"Eleftheria\", \"Manos\"], \"quiz_ids\": [ ObjectId(\"507f191e810c19729de860ea\"), ObjectId(\"507f191e810c19729de860ea\") ]\"assignment_ids\": [ObjectId(\"507f191e810c19729de860ea\"), ObjectId(\"507f191e810c19729de860ea\") ]\"multimedia_ids\": [ ObjectId(\"507f191e810c19729de860ea\"), ObjectId(\"507f191e810c19729de860ea\")]}, {\\\"subject\\\" : \\\"Maths\\\", \\\"teacher\\\": \\\"Malvinaki Vamvakari\\\", \\\"students\\\": [\\\"Mary\\\" , \\\"Eleftheria\\\", \\\"Manos\\\"], \\\"quiz_ids\\\": [ ObjectId(\\\"507f191e810c19729de860ea\\\"), ObjectId(\\\"507f191e810c19729de860ea\\\") ]\\\"assignment_ids\\\": [ObjectId(\\\"507f191e810c19729de860ea\\\"), ObjectId(\\\"507f191e810c19729de860ea\\\") ]\\\"multimedia_ids\\\": [ ObjectId(\\\"507f191e810c19729de860ea\\\"), ObjectId(\\\"507f191e810c19729de860ea\\\")]}]";   
		
	
	       return json ;
		}
	
	
	//STUDENTS: MENU --> OPTIONS --> RESULTS 
	//PROJECTS
	@RequestMapping(value = "/login/menu/projects", method = RequestMethod.GET, consumes = "application/json")   // produces = "application/json", 
	//List<Assignments>
	public String returnAssignments(HttpServletRequest request) {
		System.out.println("Education: ready to show: menu page");
		
	    List<Assignments> theProjects = new ArrayList<>();  //Assignments 
		
		//Assignments assingment1 = new Assignments("1", "assignment_type", "This is your assignment ", solutions);  //solutions-> array 
		//Assignments assingment2 = new Assignments("2", "assignment_type", "This is your assignment ", solutions);  //solutions-> array 

//		theProjects.add(assingment1);
//		theProjects.add(assingment2);
//		
		
		//String json = "{\"Title\": \"This is the home-page\"}";
		
		String json2 = "[{\"_id\": \"ObjectId(...)\", \"class\": \"MAths\",\"assignment\": \"To be or not to be. Analyze it.\",\"assignment_type\": \"text\",\"solutions\": [{\"student\": \"Mary\",\"solution\": \"death is all around us\"}]}]";
		
		//the external app sends username
		
		//retrieve from the database the projects and then send them to the external 
		
	   // returns object type of Users, which contains the username and the password
		return json2;     //thePrjects 
	}
	
	
	//QUIZES 
	@RequestMapping(value = "/login/menu/quizes", method = RequestMethod.GET, produces = "application/json",  consumes = "application/json")
	public List<Quizes> returnquizes(HttpServletRequest request) {  //, @PathVariable String username
		System.out.println("Education: ready to show: menu page");
		
		String[] questions = new String [] {"test3","test4","test5"};
		List<Quizes> theQuizes = new ArrayList<>();
		Quizes quiz = new Quizes("1", "title", "date", questions);  
		Quizes quiz1 = new Quizes("2", "title", "date",  questions);  
		Quizes quiz2 = new Quizes("3", "title", "date",  questions);  
		theQuizes.add(quiz);
		theQuizes.add(quiz1);
		theQuizes.add(quiz2);
		
		//retrieve from the database the quizes and then send them to the external 
		
	   // returns the list with the quizes
		return theQuizes;
	}
	
//	//READINGS 
//	@RequestMapping(value = "/login/menu/readings", method = RequestMethod.GET, produces = "application/json",  consumes = "application/json")
//	public List<> returnReadings(HttpServletRequest request) {
//		System.out.println("Education: ready to show: menu page");
//		
//		private List<> theQuizes;
//		
//		//the external app sends username
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
//		//the external app sends username
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
//		//the external app sends username
//		
//		//retrieve from the database the projects and then send them to the external 
//		
//	   //  returns the list with the
//		return theAnnouncements;
//	}
	
	
	
	
}
