package com.reports.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.reports.model.SessionValidityRequest;
import com.reports.model.SessionValidityResponse;

@FeignClient(name="user-service", url="http://localhost:8082")
@RibbonClient(name="user-service")
public interface UserServiceFeignProxy {

	@PostMapping("/validateSession")
	public SessionValidityResponse validateSession(@RequestBody SessionValidityRequest request);
	
}