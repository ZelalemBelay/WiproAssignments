package com.stock.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.stock.model.Stock;
import com.stock.model.User;
import com.stock.repository.InMemoryDatabase;

@Service
public class StockService {

	@Autowired
	InMemoryDatabase inMemoryDatabase;
	
	@Autowired
	RegisterServiceFeignProxy registerServiceFeignProxy;
	
	static User loggedUser = new User(null, null);

	@HystrixCommand(fallbackMethod = "purchaseStockFallBack")
	public User purchaseStock(Stock stock, String userToken, String quantity) {
		
		loggedUser = registerServiceFeignProxy.getUserByToken(userToken);
		inMemoryDatabase.purchaseStock(stock, loggedUser, quantity);
		return null;
	}
	
	public String purchaseStockFallBack() {
		return "Fallback for purchasing stock.. possibly getting user by token.";
	}

}
