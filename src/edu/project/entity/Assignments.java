package edu.project.entity;

import java.io.Serializable;

import javax.persistence.Column;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Assignments")
public class Assignments implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "_id")
	protected String _id;
	
	@Column(name = "assignment_type")
	protected String assignment_type;
	
	@Column(name = "assignment")
	protected String assignment;
	
	@Column(name = "solutions")
	protected String solutions;   //array in mongodb
	
	
	public Assignments(String _id, String assignment_type, String assignment, String solutions) {
		super();
		this._id = _id;
		this.assignment_type = assignment_type;
		this.assignment = assignment;
		this.solutions = solutions;
	}
	public Assignments(String assignment_type, String assignment, String solutions) {
		super();
		this.assignment_type = assignment_type;
		this.assignment = assignment;
		this.solutions = solutions;
	}
		
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
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
	public String getSolutions() {
		return solutions;
	}
	public void setSolutions(String solutions) {
		this.solutions = solutions;
	}
	
	
	

}
