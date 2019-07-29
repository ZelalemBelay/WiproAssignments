package com.movie.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="user-service", url="http://localhost:8082")
@RibbonClient(name="user-service")
public interface MovieServiceFeignProxy {

	@PostMapping("/validateSession")
	public SessionValidityResponse validateSession(@RequestBody SessionValidityRequest request);
}