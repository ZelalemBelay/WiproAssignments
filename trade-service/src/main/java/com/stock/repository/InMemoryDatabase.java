package com.stock.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.stock.model.Stock;
import com.stock.model.User;

@Component
public class InMemoryDatabase {

	static List<User> users = new ArrayList<>();
	static List<Stock> tickers = new ArrayList<>();

	static {
		users.add(new User("John Smith", "user", "user", "SAMPLE_VALID_TOKEN", 1000, null));
		
		tickers.add(new Stock("WIPRO", 230.55));
		tickers.add(new Stock("INFY", 949.44));
		tickers.add(new Stock("TCS", 335.65));
		tickers.add(new Stock("TECHM", 560.87));
	}

	public static List<Stock> getAllStocks() {
		return tickers;
	}	

	public static void purchaseStock(Stock stock, User loggedUser, String quantity) {
		loggedUser.getStocks().add(stock);
		loggedUser.setBalance(loggedUser.getBalance() - Double.parseDouble(quantity));
	}

	public User getUser(String userToken) {
		return users.stream().filter(pr -> pr.getAuthToken().equals(userToken)).findAny().get();
	}
}
