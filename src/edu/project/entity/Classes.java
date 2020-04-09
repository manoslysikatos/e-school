package edu.project.entity;

import java.io.Serializable;

import javax.persistence.Column;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="Classes")
public class Classes implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	protected String id;
	
	@Field(name = "subject")
	protected String subject;
	
	@Field(name = "teacher")
	protected String teacher;
	
	@Field(name = "students")
	protected String students[];     //arrays in mongodb
	
	@Field(name = "quiz_ids")
	protected String quiz_ids[];         
	
	@Field(name = "assignment_ids")
	protected String assignment_ids[];  
	 
	@Field(name = "multimedia_ids")
	protected String multimedia_ids[];  
		
	
	
	public Classes( ) {
		super();
	
	}
	
	public Classes(String subject, String teacher, String[] students, String[] quiz_ids, String[] assignment_ids,
			String[] multimedia_ids) {
		super();
		this.subject = subject;
		this.teacher = teacher;
		this.students = students;
		this.quiz_ids = quiz_ids;
		this.assignment_ids = assignment_ids;
		this.multimedia_ids = multimedia_ids;
	}

	public Classes(String id, String subject, String teacher, String[] students, String[] quiz_ids,
			String[] assignment_ids, String[] multimedia_ids) {
		super();
		this.id = id;
		this.subject = subject;
		this.teacher = teacher;
		this.students = students;
		this.quiz_ids = quiz_ids;
		this.assignment_ids = assignment_ids;
		this.multimedia_ids = multimedia_ids;
	}

	public String getid() {
		return id;
	}

	public void set_id(String id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String[] getStudents() {
		return students;
	}

	public void setStudents(String[] students) {
		this.students = students;
	}

	public String[] getQuiz_ids() {
		return quiz_ids;
	}

	public void setQuiz_ids(String[] quiz_ids) {
		this.quiz_ids = quiz_ids;
	}

	public String[] getAssignment_ids() {
		return assignment_ids;
	}

	public void setAssignment_ids(String[] assignment_ids) {
		this.assignment_ids = assignment_ids;
	}

	public String[] getMultimedia_ids() {
		return multimedia_ids;
	}

	public void setMultimedia_ids(String[] multimedia_ids) {
		this.multimedia_ids = multimedia_ids;
	}


	
	
}
