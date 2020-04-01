package edu.project.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Quizes")
public class Quizes {
	
	@Id
	protected String _id;
	protected String title;
	protected String date;
	protected String questions;
	
	
	public Quizes(String title, String date, String questions) {
		super();
		this.title = title;
		this.date = date;
		this.questions = questions;
	}
	
	
	public Quizes(String _id, String title, String date, String questions) {
		super();
		this._id = _id;
		this.title = title;
		this.date = date;
		this.questions = questions;
	}

	public String get_id() {
		return _id;
	}


	public void set_id(String _id) {
		this._id = _id;
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
	public String getQuestions() {
		return questions;
	}
	public void setQuestions(String questions) {
		this.questions = questions;
	}
	
	

}
