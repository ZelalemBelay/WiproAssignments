package com.user.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.User;
import com.user.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllMovies(@RequestHeader String sessionToken) {

		if (sessionToken.equals("admin-session-token-12345-7746-55"))
			return new ResponseEntity<>(this.userService.getAllUsers(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	@PostMapping("/signUp")
	public User getMovie(@RequestBody User user) {
		user.setId(new Random().nextInt());
		this.userService.registerUser(user);

		System.out.println("User Added" + user.getName());
		return user;
	}

	@PostMapping("/login")
	public ResponseEntity<User> addReview(@RequestBody User user) {
		if (this.userService.attemptLogin(user) != null) {
			if (user.getUsername().contains("admin"))
				user.setSessionToken("admin-session-token-12345-7746-55");
			else
				user.setSessionToken("user-session-token-12345-7746-55");
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
