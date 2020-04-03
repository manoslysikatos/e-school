package edu.project.entity;

import java.io.Serializable;

import javax.persistence.Column;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="Quizes")
public class Quizes implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	protected String id;
	
	@Field(name = "title")
	protected String title;
	
	@Field(name = "date")
	protected String date;
	
	@Field(name = "questions")
	protected String questions[];   //array in mongodb                   WHAT CONTAINS ?????
	
	public Quizes() {
		super();
	}
	
	
	public Quizes(String title, String date, String questions[]) {
		super();
		this.title = title;
		this.date = date;
		this.questions = questions;
	}
	
	
	public Quizes(String id, String title, String date, String questions[]) {
		super();
		this.id = id;
		this.title = title;
		this.date = date;
		this.questions = questions;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String[] getQuestions() {
		return questions;
	}


	public void setQuestions(String[] questions) {
		this.questions = questions;
	}



	

}
