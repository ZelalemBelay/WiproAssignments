package com.movie.service;

import com.movie.model.User;

public class SessionValidityResponse {

	User user;
	String activeToken;
	public SessionValidityResponse() {
		super();
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getActiveToken() {
		return activeToken;
	}
	public void setActiveToken(String activeToken) {
		this.activeToken = activeToken;
	}

	public boolean isValid(String sessionToken) {
		return this.activeToken.equals(sessionToken);
	}
	
}
