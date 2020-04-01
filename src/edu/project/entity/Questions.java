package edu.project.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Questions")
public class Questions {

	@Id
	protected String _id;
	protected String type; 
	protected String question;
	protected String MC_answers;
	

	public Questions(String type, String question, String mC_answers) {
		super();
		this.type = type;
		this.question = question;
		MC_answers = mC_answers;
	}

	
	public Questions(String _id, String type, String question, String mC_answers) {
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
	public String getMC_answers() {
		return MC_answers;
	}
	public void setMC_answers(String mC_answers) {
		MC_answers = mC_answers;
	}
	
	@Override
	public String toString() {
		return "Questions [type=" + type + ", question=" + question + ", MC_answers=" + MC_answers + "]";
	}
	
	
	
	
	
}
