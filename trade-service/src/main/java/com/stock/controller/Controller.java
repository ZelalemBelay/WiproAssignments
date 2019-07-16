package com.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.stock.model.Stock;
import com.stock.model.User;
import com.stock.services.StockService;

@RestController
public class Controller {

	@Autowired
	private StockService stockService;
	
	@PostMapping("/purchaseStock")
	public User registerUser(@RequestBody Stock stock, @RequestHeader String userToken, @RequestHeader String quantity) {
		
		return stockService.purchaseStock(stock, userToken, quantity);
	}
	
	
}
