package edu.project.entity;

import java.io.Serializable;

import javax.persistence.Column;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="Solutions")
public class Solutions implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	protected String id;
	
    @Field(name = "student")
	protected String student;
	
    @Field(name = "solution")
	protected String solution;	
	
	
	public Solutions(String id, String student, String solution) {
		super();
		this.id = id;
		this.student = student;
		this.solution = solution;
	}
	public Solutions(String student, String solution) {
		super();
		this.student = student;
		this.solution = solution;
	}
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStudent() {
		return student;
	}
	public void setStudent(String student) {
		this.student = student;
	}
	public String getSolution() {
		return solution;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
	

}
