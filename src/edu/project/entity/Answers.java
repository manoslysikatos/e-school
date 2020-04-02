package edu.project.entity;

import java.io.Serializable;

import javax.persistence.Column;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Answers")
public class Answers implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "_id")
	protected String _id;
	
	@Column(name = "student")
	protected String student;
	
	@Column(name = "answer")
	protected String answer;
	
		
	public Answers(String _id, String student, String answer) {
		super();
		this._id = _id;
		this.student = student;
		this.answer = answer;
	}
	public Answers(String student, String answer) {
		super();
		this.student = student;
		this.answer = answer;
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
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
	
	
}
