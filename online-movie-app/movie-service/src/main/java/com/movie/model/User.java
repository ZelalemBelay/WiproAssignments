package com.movie.model;

public class User {
  
	int id;
	String name;
	int age;
	
	String username;
	String password;
	
	String sessionToken;
	
	public String getSessionToken() {
		return sessionToken;
	}
	public void setSessionToken(String sessionToken) {
		this.sessionToken = sessionToken;
	}
	public User() {
		super();
	}
	public User(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", username=" + username + ", password="
				+ password + "]";
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
