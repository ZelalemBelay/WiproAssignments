package com.trade.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trade.model.Item;
import com.trade.model.Trade;
import com.trade.model.User;
import com.trade.repository.TradeRepository;

@Service
public class TradeService {

	private TradeRepository tradeRepository;
	private UserServiceFeignProxy userServiceFeignProxy;
	
	
	public String executeBuySeedsFallBack() {
		return "Fallback for executeBuy Seeds";
	}


	public String executeBuyVesselsFallBack() {
		return "Fallback for executeBuy Vessels";
	}

	
	@HystrixCommand(fallbackMethod = "executeBuySeedsFallBack")
	public Trade executeBuySeeds(int id, Item item) {

		Optional<List<Trade>> Otrade = tradeRepository.findByUserId(id);
		Trade trade; 
		if(Otrade.isPresent()) {
			trade = Otrade.get().get(0); 
			trade.getUser().getItems().add(item);
		} 
		else {
			User user = userServiceFeignProxy.getUser(id);
			user.getItems().add(item);
			
			trade = new Trade();
			trade.setUser(user);
			trade.setTradeNumber("CON-SEEDS-"+new Random().nextInt());
		}
		
		tradeRepository.save(trade);
		
		return trade;
	}
	
	@HystrixCommand(fallbackMethod = "executeBuyVesselsFallBack")
	public Trade executeBuyVessels(int id, Item item) {

		Optional<List<Trade>> Otrade = tradeRepository.findByUserId(id);
		Trade trade; 
		if(Otrade.isPresent()) {
			trade = Otrade.get().get(0); 
			trade.getUser().getItems().add(item);
		} 
		else {
			User user = userServiceFeignProxy.getUser(id);
			user.getItems().add(item);
			
			trade = new Trade();
			trade.setUser(user);
			trade.setTradeNumber("CON-VESSELS-"+new Random().nextInt());
		}
		
		tradeRepository.save(trade);
		
		return trade;
	}

	@HystrixCommand(fallbackMethod = "getTradesByUserIdFallBack")
	public List<Trade> getTradesByUserId(int id) {		
		return this.tradeRepository.findByUserId(id).isPresent() ? this.tradeRepository.findByUserId(id).get() : null;
	}
	
	
	public String getTradesByUserIdFallBack() {
		return "Fallback for getTradesByUserId;";
	}

}
