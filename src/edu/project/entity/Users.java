package edu.project.entity;
import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="Users")
public  class Users implements Serializable{
	
	
	//  @Transient    this simple annotation excludes the field from being persisted in the database
		     

	private static final long serialVersionUID = 1L;
	
	@Id
	protected String id;
	
	@Field(name = "username")
	protected String username;
	
	@Field(name = "password")
	protected String password;
	
	@Field(name = "fname")
	protected String fname;
	
	@Field(name = "lname")
	protected String lname;
	
	@Field(name = "sexe")
	protected String sex;
	
	@Field(name = "email")
	protected String email;
	
	@Field(name = "phone")
	protected String phone;
	
	@Field(name = "role")
	protected String role;
	
	@Field(name = "points")
	protected int points;
	
	//classes
	@DBRef
	private List<Classes> classes;
	
	public Users( ) {
		super();
	}
	
	//@PersistenceConstructor

	public Users(String id, String username, String password, String fname, String lname, String sex, String email,
			String phone, String role, int points, List<Classes> classes) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.sex = sex;
		this.email = email;
		this.phone = phone;
		this.role = role;
		this.points = points;
		this.classes = classes;
	}
	
	
	public Users( String username, String password, String fname, String lname, String sex, String email,
			String phone, String role, int points, List<Classes> classes) {
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
		this.classes = classes;
	}

	
	public Users(String _id, String username, String password, String fname, String lname, String sex, String email,
			String phone, String role, int points) {
		super();
		this.id = _id;
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


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
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

	public List<Classes> getClasses() {
		return classes;
	}

	public void setClasses(List<Classes> classes) {
		this.classes = classes;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", fname=" + fname + ", lname="
				+ lname + ", sex=" + sex + ", email=" + email + ", phone=" + phone + ", role=" + role + ", points="
				+ points + ", classes=" + classes + "]";
	}

	
	
	
	
	
}
