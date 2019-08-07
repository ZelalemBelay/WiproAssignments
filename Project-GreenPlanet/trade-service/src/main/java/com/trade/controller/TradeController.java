package com.trade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.trade.model.Item;
import com.trade.model.Trade;
import com.trade.service.TradeService;

@RestController
public class TradeController {

	@Autowired
	private TradeService tradeService;

	@PostMapping("/buySeeds")
	public Trade buySeeds(@RequestHeader int id, @RequestBody Item item) {
		if (item != null)
			return this.tradeService.executeBuySeeds(id, item);
		else
			return null;
	}

	
	@PostMapping("/buyVessels")
	public Trade buyVessels(@RequestHeader int id, @RequestBody Item item) {
		if (item != null)
			return this.tradeService.executeBuyVessels(id, item);
		else
			return null;
	}
	
	@GetMapping("/getTrades/{id}")
	public List<Trade> getTrades(@PathVariable int id){
		return this.tradeService.getTradesByUserId(id);
                    
	}
	
	
}
