package com.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.user.model.User;

@Service
public class UserService {

	static List<User> allUsers = new ArrayList<>();

	public List<User> getAllUsers() {

		return allUsers;
	}

	public User registerUser(User user) {
		allUsers.add(user);
		System.out.println(allUsers);
		return user;
	}

	public User attemptLogin(User user) {
		System.out.println(allUsers);

		if (allUsers.stream().filter(us -> user.getUsername().equalsIgnoreCase(us.getUsername())
				&& user.getPassword().equals(us.getPassword())).findAny().isPresent())
			return user;
		else
			return null;
	}
}
