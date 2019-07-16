package com.stock.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.stock.model.User;
import com.stock.repository.InMemoryDatabase;

@Service
public class RegisterService {

	@Autowired
	private InMemoryDatabase inMemoryDatabase;

	public User loginUser(User user) {

		user.setAuthToken("SAMPLE_VALID_TOKEN");
		return this.inMemoryDatabase.getUserForLogin(user);
	}

	@HystrixCommand(fallbackMethod = "registerFallBack")
	public User registerUser(User user) {
		return this.inMemoryDatabase.registerUser(user);
	}

	@HystrixCommand(fallbackMethod = "getUserByTokenFallBack")
	public User getUserByToken(String userToken) {
		return inMemoryDatabase.getUserByToken(userToken);
	}

	public String registerFallBack() {
		return "Fallback for registration.";
	}

	public String getUserByTokenFallBack() {
		return "FallBack for getting user by token";
	}

}
