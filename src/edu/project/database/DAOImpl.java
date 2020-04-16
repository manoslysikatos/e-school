package edu.project.database;

import static com.mongodb.client.model.Filters.eq;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
//import com.fasterxml.jackson.core.JsonParser;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.bson.conversions.Bson;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

import org.bson.Document;

import edu.project.entity.Assignments;
import edu.project.entity.Classes;
import edu.project.entity.Quizes;
import edu.project.entity.Users;

import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.bson.types.ObjectId;

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
	private String st_username = null;
	
	@Override
	public MongoDatabase connect_to_database()  {  //establish connection with the database 
		MongoDatabase database = null;
		try{
			mongoClient = new MongoClient(
			    new MongoClientURI(
			        "mongodb+srv://Eleftheria_user1:Eleftheria@cluster0-qwkws.mongodb.net/test?authSource=admin&replicaSet=Cluster0-shard-0&readPreference=primary&appname=MongoDB%20Compass%20Community&ssl=true"
			    )
			);
		}catch(Exception e) {
			e.getStackTrace();
		}
		
		try{
			database = mongoClient.getDatabase("eschool");
		}catch(Exception e) {
			e.getStackTrace();
		}
		System.out.println("connection to database ok ");
		return database;
	}

	
	@Override
	@Transactional   
	public String find_user(MongoDatabase database, String username) {   	//finds the user in the database based on the given username 
		System.out.println("find_user starting");
		//session.setAttribute("student's_username", username);    //add username in session 
		return find_the_user(database,username);  
	}
	
	
	@Override
	@Transactional
	public List<String> find_Assignments_for_a_student(MongoDatabase database, HttpSession session) {
		System.out.println("find_Assignments_for_a_student starting\n");

		st_username = (String) session.getAttribute("student's_username");
		String user_json_text = find_the_user(database, st_username); // the method returns a string which contains a json

        List<String> assignments_ids = find_ids(get_user_classes(user_json_text), "assignments");  
        List<String> assignments = find_the_assignments(database,assignments_ids);
        return assignments;
	}
	
	
	@Override
	@Transactional 
	public List<String> find_Quizes_for_a_student(MongoDatabase database, HttpSession session) {  //finds the quizes that a user/student has to answer in the database based on the given 
		System.out.println("find_Quizes_for_a_student starting");

		st_username = (String) session.getAttribute("student's_username");
		String user_json_text = find_the_user(database, st_username); // the method returns a string which contains a  json
																		
        List<String> quiz_ids = find_ids(get_user_classes(user_json_text), "quiz_ids"); 
	    return find_the_quizes(database,quiz_ids);
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
		
//		try{
//			mongoClient.close();
//		}catch(Exception e) {
//			e.getStackTrace();
//		}
		return json; 
	}
	
	
	private JsonArray get_user_classes(String user_json_text) { //gets the array : "classes", from the json that the method: "find_the_user" returned
		System.out.println("get_user_classes is beginning\n");
		JsonArray array = null;
		JsonObject jsonobject = null;
		JsonParser parser = new JsonParser();

		if(user_json_text != null) {
			try {
				// JSON string to JsonArray
				jsonobject = parser.parse(user_json_text).getAsJsonObject();
				array = jsonobject.get("classes").getAsJsonArray();
				
			} catch (Exception ex) {
				System.out.println("error in get_user_classes" + ex);
				ex.getStackTrace();
			}
		}else {
			user_json_text = "{ \"result\" : \"none\" }" ;
			jsonobject = parser.parse(user_json_text).getAsJsonObject();
			array = jsonobject.getAsJsonArray();
		}
		System.out.println("JsonArray user's classes: " + array+"\n");
		return array;
	}
	 
	private List<String> find_ids(JsonArray jsonArray, String array_name_for_ids) {   //the method finds and returns only the assignment or quiz ids, which are contained in the jsonArray
		System.out.println("find_assignment_ids is beginning\n");
		
		List<String> assignment_ids = new ArrayList<>();
	    System.out.println("JsonArray jsonArray is " +jsonArray+"\n");
	    
	    JsonObject jsonobject_classes_array = null;
	    JsonArray json_array_assignments = null;
	    JsonObject json_obj_assignments_ids = null;
	    if(jsonArray.size() >0) {
		    for(int i=0; i<jsonArray.size(); i++) {
				 jsonobject_classes_array = jsonArray.get(i).getAsJsonObject();
				// System.out.println("jsonobject_classes_array " +	jsonobject_classes_array+"\n" );
				 json_array_assignments = jsonobject_classes_array.get(array_name_for_ids).getAsJsonArray();  //array_name_for_ids = "assignments" or "quiz_ids"
				 //System.out.println("jsonobject_classes_array.get(\"assignments\") OR json_array_assignments : " +	json_array_assignments +"\n");
	             
				 for(int x=0; x<json_array_assignments.size(); x++) {
					 json_obj_assignments_ids = (JsonObject) json_array_assignments.get(x);
					 String id = json_obj_assignments_ids.get("$oid").getAsString();
					 assignment_ids.add(id);
				 }
		    	
		    }
	    }else {
	    	 assignment_ids.add("NO IDS");
	    }
		System.out.println("assignment_ids" + assignment_ids);

	    return assignment_ids;
	}
	 

	private  List<String> find_the_assignments(MongoDatabase database,List <String> assignments_ids) { //for every assignment id , searches in the collection to find the whole assignment,  in order to return it as json in string 
		System.out.println("find_the_assignments is starting\n");
        List<String> assignments = new ArrayList<>();

		for (String id : assignments_ids) {
			try {
		        Bson filter = eq("_id", new ObjectId(id));
		        collection = database.getCollection("Assignments");
		        result = collection.find(filter);
		        cursor = result.iterator();
				if (cursor == null) {
					json = "{ \"result\" : \"none\" }";
				} else { // cursor.hasNext()
					document = cursor.next();
					json = document.toJson();
				}
			} catch (Exception e) {
			e.getMessage();
		    }
			System.out.println("json "+json);

			assignments.add(json);
		}
		return assignments;
	}

	private List<String> find_the_quizes(MongoDatabase database, List<String> quizes_ids) { // for every quiz id , searches in
																						// the collection to find the
																						// whole whole, in order to
																						// return it as json in string
		System.out.println("find_the_quizes is starting\n");
		List<String> quizes = new ArrayList<>();

		for (String id : quizes_ids) {
			try {
		        Bson filter = eq("_id", new ObjectId(id));
		        collection = database.getCollection("Quizzes");
		        result = collection.find(filter);
		        cursor = result.iterator();
				if (cursor == null) {
					json = "{ \"result\" : \"none\" }";
				} else { // cursor.hasNext()
					document = cursor.next();
					json = document.toJson();
				}
			} catch (Exception e) {
			e.getMessage();
		    }
			System.out.println("json "+json);
			quizes.add(json);
		}
			return quizes; 
	} 
	 
	
	
	
	
	
	
	

}
