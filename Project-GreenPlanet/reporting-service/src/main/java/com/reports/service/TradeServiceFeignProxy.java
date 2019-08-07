package com.reports.service;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.reports.model.Trade;

@FeignClient(name="trade-service", url="http://localhost:8083")
@RibbonClient(name="trade-service")
public interface TradeServiceFeignProxy {

	@GetMapping("/getTrades/{id}")
	public List<Trade> getTrades(@PathVariable int id);
}


