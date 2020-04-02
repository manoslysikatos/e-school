package edu.project.entity;

import java.io.Serializable;

import javax.persistence.Column;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Questions")
public class Questions  implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "_id")
	protected String _id;
	
	@Column(name = "type")
	protected String type; 
	
	@Column(name = "question")
	protected String question;
	
	@Column(name = "MC_answers")
	protected int MC_answers;   //array me ints
	

	public Questions(String type, String question, int mC_answers) {
		super();
		this.type = type;
		this.question = question;
		MC_answers = mC_answers;
	}

	
	public Questions(String _id, String type, String question, int  mC_answers) {
		super();
		this._id = _id;
		this.type = type;
		this.question = question;
		MC_answers = mC_answers;
	}



	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
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
	public int getMC_answers() {
		return MC_answers;
	}
	public void setMC_answers(int mC_answers) {
		MC_answers = mC_answers;
	}
	
	@Override
	public String toString() {
		return "Questions [type=" + type + ", question=" + question + ", MC_answers=" + MC_answers + "]";
	}
	
	
	
	
	
}
