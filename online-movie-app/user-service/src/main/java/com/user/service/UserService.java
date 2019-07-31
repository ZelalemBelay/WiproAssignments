package com.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.user.model.User;

@Service
public class UserService {

	static List<User> allUsers = new ArrayList<>();

	public List<User> getAllUsers() {

		return allUsers;
	}

	@HystrixCommand(fallbackMethod = "registerUserFallBack")
	public User registerUser(User user) {
		allUsers.add(user);
		System.out.println(allUsers);
		return user;
	}

	@HystrixCommand(fallbackMethod = "loginUserFallBack")
	public User attemptLogin(User user) {
		System.out.println(allUsers);

		if (allUsers.stream().filter(us -> user.getUsername().equalsIgnoreCase(us.getUsername())
				&& user.getPassword().equals(us.getPassword())).findAny().isPresent())
			return user;
		else
			return null;
	}
	
	
	public String registerUserFallBack() {
		return "Fallback for registerUser";
	}
	
	public String loginUserFallBack() {
		return "Fallback for loginUser";
	}
	
}
