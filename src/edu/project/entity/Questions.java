package edu.project.entity;

import java.io.Serializable;

import javax.persistence.Column;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="Questions")
public class Questions  implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	protected String id;
	
	@Field(name = "type")
	protected String type; 
	
	@Field(name = "question")
	protected String question;
	
	@Field(name = "MC_answers")
	protected int MC_answers[];   //array ints
	
	public Questions() {
		super();
	}

	public Questions(String type, String question, int mC_answers[]) {
		super();
		this.type = type;
		this.question = question;
		MC_answers = mC_answers;
	}

	
	public Questions(String id, String type, String question, int  mC_answers[]) {
		super();
		this.id = id;
		this.type = type;
		this.question = question;
		MC_answers = mC_answers;
	}



	public String getid() {
		return id;
	}

	public void set_id(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}

	public int[] getMC_answers() {
		return MC_answers;
	}


	public void setMC_answers(int[] mC_answers) {
		MC_answers = mC_answers;
	}
	

	
	
}
