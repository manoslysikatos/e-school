package edu.project.database;

import java.util.List;
import javax.servlet.http.HttpSession;
import com.mongodb.client.MongoDatabase;

import edu.project.entity.*;

public interface DAO {

	public MongoDatabase connect_to_database(); //establish connection with the database 
	public String find_user(MongoDatabase database,String username); //finds the user in the database based on the given username 

	public List<String> find_Assignments_for_a_student(MongoDatabase database, HttpSession session); //finds the assignments that a user/student has to answer in the database based on the given 

	public List<String> find_Quizes_for_a_student(MongoDatabase database, HttpSession session); //finds the quizes that a user/student has to answer in the database based on the given 

	





}
