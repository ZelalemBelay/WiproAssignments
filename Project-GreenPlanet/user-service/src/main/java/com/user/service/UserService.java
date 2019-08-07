package com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.user.model.User;
import com.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@HystrixCommand(fallbackMethod = "registerUserFallBack")
	public User registerUser(User user) {
		userRepository.save(user);
		return user;
	}

	@HystrixCommand(fallbackMethod = "loginUserFallBack")
	public User attemptLogin(User user) {
		List<User> users = userRepository.getUserByEmail(user.getEmail(), user.getPassword());

		if (users.size() > 0)
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

	public List<User> getAllUsers() {
		return this.userRepository.findAll();
	}

	public User getUser(int id) {

		if (userRepository.findById(id).isPresent())
			return userRepository.findById(id).get();
		else
			return null;
	}

}
