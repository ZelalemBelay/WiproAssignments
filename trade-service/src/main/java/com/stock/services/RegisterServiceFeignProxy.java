package com.stock.services;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stock.model.User;

@FeignClient(name="register-service", url="http://localhost:8400")
@RibbonClient(name="register-service")
public interface RegisterServiceFeignProxy {

	@PostMapping("/getUserByToken")
	public User getUserByToken(@RequestParam String token);
}