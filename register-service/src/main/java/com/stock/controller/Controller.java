package com.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.stock.model.User;
import com.stock.services.RegisterService;

@RestController
public class Controller {

	@Autowired
	private RegisterService registerService;
	
	@PostMapping("/register")
	public User registerUser(@RequestBody User user) {
		return registerService.registerUser(user);
	}
	
	@PostMapping("/getUserByToken")
	public User userLogin(@RequestParam String userToken) {
		return registerService.getUserByToken(userToken);
	}
	
}
