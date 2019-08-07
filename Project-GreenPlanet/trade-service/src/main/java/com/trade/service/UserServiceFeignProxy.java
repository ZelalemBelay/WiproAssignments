package com.trade.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.trade.model.User;

@FeignClient(name="user-service", url="http://localhost:8082")
@RibbonClient(name="user-service")
public interface UserServiceFeignProxy {

	@GetMapping("/getUser/{id}")
	public User getUser(@PathVariable int id);
	
}