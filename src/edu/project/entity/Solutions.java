package edu.project.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Solutions")
public class Solutions {
	
	@Id
	protected String _id;
	protected String student;
	protected String solution;	
	
	
	public Solutions(String _id, String student, String solution) {
		super();
		this._id = _id;
		this.student = student;
		this.solution = solution;
	}
	public Solutions(String student, String solution) {
		super();
		this.student = student;
		this.solution = solution;
	}
	
		
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
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
