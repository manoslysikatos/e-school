package edu.project.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="Assignments")
public class Assignments implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	protected String id;

	//other way 
//	 @Id
//	  private ObjectId id;

	@Field(name = "assignment_type")
	protected String assignment_type;
	
	@Field(name = "assignment")
	protected String assignment;
	
	@Field(name = "solutions")
	protected String solutions[];   //array in mongodb      ???????
	
	
	public Assignments() {
		super();
	}
	
	public Assignments(String assignment_type, String assignment, String[] solutions) {
		super();
		this.assignment_type = assignment_type;
		this.assignment = assignment;
		this.solutions = solutions;
	}
	
	public Assignments(String id, String assignment_type, String assignment, String[] solutions) {
		super();
		this.id = id;
		this.assignment_type = assignment_type;
		this.assignment = assignment;
		this.solutions = solutions;
	}
	public String[] getSolutions() {
		return solutions;
	}
	public void setSolutions(String[] solutions) {
		this.solutions = solutions;
	}
	public String getid() {
		return id;
	}
	public void setid(String id) {
		this.id = id;
	}
	public String getAssignment_type() {
		return assignment_type;
	}
	public void setAssignment_type(String assignment_type) {
		this.assignment_type = assignment_type;
	}
	public String getAssignment() {
		return assignment;
	}
	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}

}
