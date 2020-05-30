package com.easylearning.entity;

public class User {

	int user_id;
	String username;
	String emailid;
	public User(String username, String emailid) {
		super();
	
		this.username = username;
		this.emailid = emailid;
	}
	public User(int user_id, String username, String emailid) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.emailid = emailid;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	
	
	
}
