package edu.project.entity;

import java.io.Serializable;

import javax.persistence.Column;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Solutions")
public class Solutions implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "_id")
	protected String _id;
	
	@Column(name = "student")
	protected String student;
	
	@Column(name = "solution")
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
