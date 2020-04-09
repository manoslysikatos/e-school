package edu.project.database;

import static com.mongodb.client.model.Filters.eq;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;

//import com.google.gson.Gson;
import org.bson.conversions.Bson;
import org.hibernate.mapping.Set;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpSession;

import org.bson.Document;

import edu.project.entity.Assignments;
import edu.project.entity.Classes;
import edu.project.entity.Quizes;
import edu.project.entity.Users;

import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.mongodb.*;

/*
* Requires the MongoDB Java Driver.
* https://mongodb.github.io/mongo-java-driver
*/

@Repository
public class DAOImpl implements DAO {
	private MongoClient mongoClient = null;
	private Bson filter=null;
	private MongoCollection<Document> collection = null;
	private FindIterable<Document> result = null;

	private String json = null ;
	private Document document = null;
	private MongoCursor<Document> cursor = null;
	private ObjectMapper mapper = null;
	private String st_username = null;
	
	@Override
	public MongoDatabase connect_to_database()  {  //establish connection with the database 

		try{
			mongoClient = new MongoClient(
			    new MongoClientURI(
			        "mongodb+srv://Eleftheria_user1:Eleftheria@cluster0-qwkws.mongodb.net/test?authSource=admin&replicaSet=Cluster0-shard-0&readPreference=primary&appname=MongoDB%20Compass%20Community&ssl=true"
			    )
			);
			System.out.println("mongoClient = " + mongoClient);
		}catch(Exception e) {
			e.getStackTrace();
		}
					
		System.out.println("mongoClient = " +mongoClient);
		MongoDatabase database = mongoClient.getDatabase("eschool");
		System.out.println("database = " +database);
		return database;
	}

	
	@Override
	@Transactional   
	public String find_user(MongoDatabase database, String username) {   	//finds the user in the database based on the given username 
		System.out.println("find_user starting");
		//session.setAttribute("student's_username", username);    //add username in session 
		return find_the_user(database,username);  
	}
	
	

	protected String find_the_user(MongoDatabase database, String username){    //looks in the database to find the user based on the given username 
        filter = eq("username", username);
		try{
			collection = database.getCollection("Users");
			result = collection.find(filter);
			cursor = result.iterator();
			if(cursor == null) {
				json = "{ \"result\" : \"none\" }" ;
			}else {   //cursor.hasNext() 		
				    document = cursor.next();	
				    //document.getString("identifier");
				   json = document.toJson();		
			}
		}catch(Exception e){
			e.getMessage();
		}
		
		try{
			mongoClient.close();
		}catch(Exception e) {
			e.getStackTrace();
		}
		return json; 
	}


	@Override
	@Transactional
	public String find_Assignments_for_a_student(MongoDatabase database, HttpSession session) {
		System.out.println("find_Assignments_for_a_student starting");

		st_username = (String) session.getAttribute("student's_username");
		String user_json_text = find_the_user(database, st_username); // the method returns a string which contains a json
        List<String[]> assignments_ids = 
		find_assignment_ids(user_json_text);
		return find_the_assignments(database,assignments_ids);
	}
	
	

	@Override
	@Transactional 
	public String find_Quizes_for_a_student(MongoDatabase database, HttpSession session) {  //finds the quizes that a user/student has to answer in the database based on the given 
		System.out.println("find_Quizes_for_a_student starting");

		st_username = (String) session.getAttribute("student's_username");
		String user_json_text = find_the_user(database, st_username); // the method returns a string which contains a
																		// json
        List<String[]> quiz_ids = 
		find_quiz_ids(user_json_text);
	    return	find_the_quizes(database,quiz_ids);
	}

	 private List<String[]> find_quiz_ids(String user_json_text) {
		mapper = new ObjectMapper();

		Users user = null;
		List<String[]> quiz_ids = new ArrayList<>();
		
		try {
			// JSON string to Java object
			System.out.println("before conversion" + user_json_text);

			//user =  mapper.readValue(user_json_text, Users.class);
			Gson gson = new Gson();

			user = gson.fromJson(user_json_text, Users.class); // error multimedia ids
		} catch (Exception ex) {
			System.out.println("errorcx");
			ex.getMessage();
			ex.getStackTrace();
			ex.getCause();
		}

		
		 List<Classes> st_classes = user.getClasses();
		 for( Classes classes :st_classes) {
			 System.out.println("classes.getQuiz_ids();" + classes.getQuiz_ids() );
			//add  
			 quiz_ids.add(classes.getQuiz_ids());
		 }  
		 return  quiz_ids;
	}
	 
	 
	private List<String[]> find_assignment_ids(String user_json_text) {
		mapper = new ObjectMapper();
		Users user = null;
		List<String[]> assignment_ids = new ArrayList<>();

		try {
			// JSON string to Java object
			System.out.println("before conversion" + user_json_text);

			// user = mapper.readValue(user_json_text, Users.class);
			Gson gson = new Gson();

			user = gson.fromJson(user_json_text, Users.class); // error multimedia ids
		} catch (Exception ex) {
			System.out.println("errorcx");
			ex.getMessage();
			ex.getStackTrace();
			ex.getCause();
		}

		List<Classes> st_classes = null;
		try{
			st_classes= user.getClasses();
		}catch (Exception ex) {
			System.out.println("errorcx");
			ex.getMessage();
			ex.getStackTrace();
			ex.getCause();
		}
		
		try {
		for (Classes classes : st_classes) {
			System.out.println("classes.getQuiz_ids();" + classes.getAssignment_ids());
			// add +++
			assignment_ids.add(classes.getAssignment_ids());
		}
		}catch (Exception ex) {
			System.out.println("errorcx");
			ex.getMessage();
			ex.getStackTrace();
			ex.getCause();
		}
		System.out.println("assignment_ids" + assignment_ids);

	    return assignment_ids;
	}
	 

	private String find_the_assignments(MongoDatabase database,List <String[]> assignments_ids) {
	
		for(String[] id :assignments_ids ) {
			filter = eq("_id", id);  //???????????????????
			try{
				collection = database.getCollection("Assignments");
				result = collection.find(filter);
				cursor = result.iterator();
				
				if(cursor == null) {
					json = "{ \"result\" : \"none\" }" ;
				}else {   //cursor.hasNext() 		
					    document = cursor.next();	
					   json = document.toJson();		
				}
			}catch(Exception e){
				e.getMessage();
			}
		}
			try{
				mongoClient.close();
			}catch(Exception e) {
				e.getStackTrace();
			}
			return json; 
		}
	private String find_the_quizes(MongoDatabase database,List <String[]> quizes_ids) {
		for(String[] id :quizes_ids ) {
			filter = eq("_id", id);  //???????????????????
			try{
				collection = database.getCollection("Assignments");
				result = collection.find(filter);
				cursor = result.iterator();
				
				if(cursor == null) {
					json = "{ \"result\" : \"none\" }" ;
				}else {   //cursor.hasNext() 		
					    document = cursor.next();	
					   json = document.toJson();		
				}
			}catch(Exception e){
				e.getMessage();
			}
		}
			try{
				mongoClient.close();
			}catch(Exception e) {
				e.getStackTrace();
			}
			return json; 
	} 
	 
	 
	 

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
