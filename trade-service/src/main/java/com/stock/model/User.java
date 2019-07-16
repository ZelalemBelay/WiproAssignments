package com.stock.model;

import java.util.ArrayList;
import java.util.List;

public class User {

	String name;
	String username;
	String password;
	
	String authToken;
	double balance;
	List<Stock> stocks = new ArrayList<Stock>();

	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	
	public User(String name, String username, String password, String authToken, double balance, List<Stock> stocks) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.authToken = authToken;
		this.balance = balance;
		this.stocks = stocks;
	}


	public double getBalance() {
		return balance;
	}
	

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
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

	public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
	
}
