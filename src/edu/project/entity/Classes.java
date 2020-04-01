package edu.project.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Classes")
public class Classes {
	
	@Id
	protected String _id;
	protected String subject;
	protected String teacher;
	protected String students;
	protected String quiz_ids; //int or string 
	protected String assignment_ids;
	protected String multimedia_ids;
		
	
	public Classes(String _id, String subject, String teacher, String students, String quiz_ids, String assignment_ids,
			String multimedia_ids) {
		super();
		this._id = _id;
		this.subject = subject;
		this.teacher = teacher;
		this.students = students;
		this.quiz_ids = quiz_ids;
		this.assignment_ids = assignment_ids;
		this.multimedia_ids = multimedia_ids;
	}

	public Classes(String subject, String teacher, String students, String quiz_ids, String assignment_ids,
			String multimedia_ids) {
		super();
		this.subject = subject;
		this.teacher = teacher;
		this.students = students;
		this.quiz_ids = quiz_ids;
		this.assignment_ids = assignment_ids;
		this.multimedia_ids = multimedia_ids;
	}
	
	
	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
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
	public String getStudents() {
		return students;
	}
	public void setStudents(String students) {
		this.students = students;
	}
	public String getQuiz_ids() {
		return quiz_ids;
	}
	public void setQuiz_ids(String quiz_ids) {
		this.quiz_ids = quiz_ids;
	}
	public String getAssignment_ids() {
		return assignment_ids;
	}
	public void setAssignment_ids(String assignment_ids) {
		this.assignment_ids = assignment_ids;
	}
	public String getMultimedia_ids() {
		return multimedia_ids;
	}
	public void setMultimedia_ids(String multimedia_ids) {
		this.multimedia_ids = multimedia_ids;
	}

	@Override
	public String toString() {
		return "Classes [subject=" + subject + ", teacher=" + teacher + ", students=" + students + ", quiz_ids="
				+ quiz_ids + ", assignment_ids=" + assignment_ids + ", multimedia_ids=" + multimedia_ids + "]";
	}

	
	
}
