package edu.project.entity;
import java.io.Serializable;

import javax.persistence.Column;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Users")
public class Users implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "_id")
	protected String _id;
	
	@Column(name = "username")
	protected String username;
	
	@Column(name = "password")
	protected String password;
	
	@Column(name = "fname")
	protected String fname;
	
	@Column(name = "lname")
	protected String lname;
	
	@Column(name = "sex")
	protected String sex;
	
	@Column(name = "email")
	protected String email;
	
	@Column(name = "phone")
	protected String phone;
	
	@Column(name = "role")
	protected String role;
	
	@Column(name = "points")
	protected int points;
	
	
	public Users(String _id, String username, String password, String fname, String lname, String sex, String email,
			String phone, String role, int points) {
		super();
		this._id = _id;
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.sex = sex;
		this.email = email;
		this.phone = phone;
		this.role = role;
		this.points = points;
	}


	public Users(String username, String password, String fname, String lname, String sex, String email, String phone,
			String role, int points) {
		super();
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.sex = sex;
		this.email = email;
		this.phone = phone;
		this.role = role;
		this.points = points;
	}


	public String get_id() {
		return _id;
	}


	public void set_id(String _id) {
		this._id = _id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public int getPoints() {
		return points;
	}


	public void setPoints(int points) {
		this.points = points;
	}


	@Override
	public String toString() {
		return "Users [username=" + username + ", password=" + password + ", fname=" + fname + ", lname=" + lname
				+ ", sex=" + sex + ", email=" + email + ", phone=" + phone + ", role=" + role + ", points=" + points
				+ "]";
	}
	
	
	
	
	
	

}
