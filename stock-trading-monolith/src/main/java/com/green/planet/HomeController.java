package com.green.planet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	static List<User> users = new ArrayList<>();
	static User loggedUser = new User(null, null);
	static List<Item> tickers = new ArrayList<>();

	static {
		tickers.add(new Item("WIPRO", 230.55));
		tickers.add(new Item("INFY", 949.44));
		tickers.add(new Item("TCS", 335.65));
		tickers.add(new Item("TECHM", 560.87));
	}

	@RequestMapping({ "/home", "/" })
	public String welcome(Map<String, Object> model) {
		model.put("key1", "Wipro");
		return "home";
	}

	@RequestMapping("/register")
	public String register(Map<String, Object> model) {
		return "register";
	}

	@RequestMapping("/purchaseStock")
	public String purchaseStock(@RequestParam("ticker") String ticker, @RequestParam("quantity") String quantity) {

		Item st = tickers.get(tickers.indexOf(new Item(ticker, Double.parseDouble(quantity))));
		loggedUser.getStocks().add(st);
		loggedUser.setBalance(loggedUser.getBalance() - Double.parseDouble(quantity));

		return "success";
	}

	@RequestMapping("/registerUser")
	public String registerUser(@RequestParam("userId") String userId, @RequestParam("password") String password) {

		User user = new User(userId, password);
		user.setBalance(1000);
		users.add(user);

		return "login";
	}

	@RequestMapping("/login")
	public String login(Map<String, Object> model) {
		model.put("key1", "Wipro");
		return "login";
	}

	@RequestMapping("/userLogin")
	public String userLogin(@RequestParam("userId") String userId, @RequestParam("password") String password) {

		User user = new User(userId, password);

		if (users.contains(user)) {

			loggedUser = user;
			return "dash";
		} else
			return "login";
	}

}