package com.user.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.user.Constants;
import com.user.model.User;
import com.user.service.SessionValidityRequest;
import com.user.service.SessionValidityResponse;
import com.user.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers(@RequestHeader String sessionToken) {

		if (sessionToken.equals(Constants.ADMIN_SESSION_TOKEN))
			return new ResponseEntity<>(this.userService.getAllUsers(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}
	
	@GetMapping("/getUser/{id}")
	public User getUser(@PathVariable int id) {

		return this.userService.getUser(id);
	}

	@PostMapping("/register")
	public User register(@RequestBody User user) {
		user.setId(new Random().nextInt());
		this.userService.registerUser(user);

		System.out.println("User Added" + user.getName());
		return user;
	}

	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody User user) {
		
		//This method does the authentication and provides a session to the user. 
		if (this.userService.attemptLogin(user) != null) {
				user.setSessionToken(Constants.USER_SESSION_TOKEN);
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/validateSession")
	public SessionValidityResponse validateSession(@RequestBody SessionValidityRequest request) {
		// this is a sample validator in real time this data will come from the session factory or database.
		
		SessionValidityResponse res = new SessionValidityResponse();
		res.setActiveToken(Constants.USER_SESSION_TOKEN);
		
		return res;
	}

}
