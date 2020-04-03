package edu.project.entity;

import java.io.Serializable;

import javax.persistence.Column;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="Answers")
public class Answers implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	protected String id;
	
	@Field(name = "student")
	protected String student;
	
	@Field(name = "answer")
	protected String answer;
	
	public Answers() {
		super();
	}
		
	public Answers(String id, String student, String answer) {
		super();
		this.id = id;
		this.student = student;
		this.answer = answer;
	}
	public Answers(String student, String answer) {
		super();
		this.student = student;
		this.answer = answer;
	}
		
	public String get_id() {
		return id;
	}
	public void set_id(String _id) {
		this.id = _id;
	}
	public String getStudent() {
		return student;
	}
	public void setStudent(String student) {
		this.student = student;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
}
