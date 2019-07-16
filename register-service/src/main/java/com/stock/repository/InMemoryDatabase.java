package com.stock.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.stock.model.User;

@Component
public class InMemoryDatabase {

	static List<User> users = new ArrayList<>();
	static User loggedUser = new User(null, null);


	public static User getUserForLogin(User user) {
		if (users.contains(user)) {
			loggedUser = user;
			return user;
		} else {
			loggedUser = null;
			return null;
		}

	}
	
	public static User registerUser(User user) {
		users.add(user);
		
		return user;
	}

	public User getUserByToken(String userToken) {
		return users.stream().filter(pr -> pr.getAuthToken().equals(userToken)).findAny().get();
	}

}
