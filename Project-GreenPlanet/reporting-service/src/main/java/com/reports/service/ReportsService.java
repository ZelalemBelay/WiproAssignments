package com.reports.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.reports.model.SessionValidityRequest;
import com.reports.model.SessionValidityResponse;
import com.reports.model.Trade;
import com.reports.model.UserReport;
import com.reports.repository.ReportsRepository;

@Service
public class ReportsService {

	@Autowired
	TradeServiceFeignProxy tradeServiceFeignProxy;

	@Autowired
	UserServiceFeignProxy userServiceFeignProxy;
	
	@Autowired
	ReportsRepository reportsRepository;
	
	@HystrixCommand(fallbackMethod = "getTradesByUserIdFallBack")
	private List<Trade> getTrades(int id) {
		List<Trade> trades = this.tradeServiceFeignProxy.getTrades(id);
		return trades;
	}
	
	@HystrixCommand(fallbackMethod = "getTradesByUserIdFallBack")
	public UserReport getReport(String sessionString) {
		
		SessionValidityRequest req  = new SessionValidityRequest();
		req.setSessionToken(sessionString);
		
	    SessionValidityResponse response = this.userServiceFeignProxy.validateSession(req);
	    
	    List<Trade> trades  = this.getTrades(response.getUser().getId());
	    
	    UserReport report = new UserReport();
	    report.setReportDate(new Date().toString());
	    report.setTrade(trades);
	    report.setBalance(response.getUser().getBalance());
	    double totalAmount = response.getUser().getItems().stream().collect(Collectors.summingDouble(i -> i.getPrice()));
	    
	    report.setTotalAmount(totalAmount);
	    
	    return this.reportsRepository.save(report);
	}
}