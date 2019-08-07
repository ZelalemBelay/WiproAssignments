package com.green.planet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ItemRepository itemRepository;

	static User loggedUser = new User(null, null);

	@RequestMapping({ "/home", "/" })
	public String welcome(Map<String, Object> model) {

		model.put("key1", "Wipro");

		return "home";
	}

	@RequestMapping("/buySeeds")
	public String buySeeds(ModelMap model) {

		List<Item> itemList = new ArrayList<>();
		itemList = itemRepository.findAll().stream().filter(i -> i.getId() <= 3).collect(Collectors.toList());
		model.addAttribute("itemList", itemList);

		return "buySeeds";
	}

	@RequestMapping("/buyVessels")
	public String buyVessels(ModelMap model) {
		List<Item> itemList = new ArrayList<>();
		itemList = itemRepository.findAll().stream().filter(i -> i.getId() > 3).collect(Collectors.toList());
		model.addAttribute("itemList", itemList);
		return "buyVessels";
	}

	@RequestMapping("/viewBalance")
	public String showBalance(ModelMap model) {

		model.addAttribute("loggedUser", loggedUser);
		return "viewBalance";
	}

	@RequestMapping("/register")
	public String register(Map<String, Object> model) {
		return "register";
	}

	@RequestMapping("/purchaseSeeds")
	public String purchaseStock(ModelMap model, @RequestParam("id") int id, @RequestParam("quantity") int quantity) {
		List<Item> itemList = new ArrayList<>();
		itemList = itemRepository.findAll().stream().filter(i -> i.getId() <= 3).collect(Collectors.toList());

		if(id > 3) {
			model.addAttribute("error", "Selected Id does not exist");
			model.addAttribute("itemList", itemList);

			return "buySeeds";
		}
		
		Optional<Item> it = itemList.stream().filter(i -> i.getId() == id).findAny();
		if (it.isPresent()) {
			Item item = it.get();
			if(item.getQuantity() < quantity) {
				model.addAttribute("itemList", itemList);
				model.addAttribute("error", "Selected quantity exceeds the the available quantity of the item");
				
				return "buySeeds";
			}
			
			if(loggedUser.getBalance() < (item.getPrice() * quantity)) {
				model.addAttribute("itemList", itemList);
				model.addAttribute("error", "You dont have enough funds to cover this purchase.");
				
				return "buySeeds";
			}
			
			item.setQuantity(quantity);
			loggedUser.getItems().add(item);
			loggedUser.setBalance(loggedUser.getBalance() - (quantity * item.getPrice()));

		}

		model.addAttribute("loggedUser", loggedUser);
		System.out.println(loggedUser);

		return "viewBalance";
	}

	@RequestMapping("/purchaseVessels")
	public String purchaseVessels(ModelMap model, @RequestParam("id") int id, @RequestParam("quantity") int quantity) {
		List<Item> itemListVessels = new ArrayList<>();
		itemListVessels = itemRepository.findAll().stream().filter(i -> i.getId() > 3).collect(Collectors.toList());

		if(id < 4) {
			model.addAttribute("error", "Selected Id does not exist");
			model.addAttribute("itemList", itemListVessels);

			return "buyVessels";
		}
		
		Optional<Item> it = itemListVessels.stream().filter(i -> i.getId() == id).findAny();
		if (it.isPresent()) {
			Item item = it.get();
			System.out.println(item.getQuantity() + " - "+ quantity);
			if(item.getQuantity() < quantity) {
				model.addAttribute("itemList", itemListVessels);
				model.addAttribute("error", "Selected quantity exceeds the the available quantity of the item");
				return "buyVessels";
			}
			
			if(loggedUser.getBalance() < (item.getPrice() * quantity)) {
				model.addAttribute("itemList", itemListVessels);
				model.addAttribute("error", "You dont have enough funds to cover this purchase.");
				
				return "buyVessels";
			}
			
			item.setQuantity(quantity);
			loggedUser.getItems().add(item);
			
			
			loggedUser.setBalance(loggedUser.getBalance() - (quantity * item.getPrice()));

//			userRepository.delete(loggedUser);
//
//			userRepository.saveAndFlush(loggedUser);
		}

		model.addAttribute("loggedUser", loggedUser);
		System.out.println(loggedUser);

		return "viewBalance";
	}

	@RequestMapping("/registerUser")
	public String registerUser(Map<String, Object> model, @RequestParam("email") String email,
			@RequestParam("password") String password, @RequestParam("mobileNum") String mobileNum,
			@RequestParam("blockNum") String blockNum, @RequestParam("floorNum") String floorNum,
			@RequestParam("houseNum") String houseNum) {

		User user = new User(email, password);
		user.setMobileNum(mobileNum);
		user.setFloorNum(floorNum);
		user.setHouseNum(houseNum);
		user.setBlockNum(blockNum);
		user.setBalance(2000);

		userRepository.save(user);

		System.out.println(user);

		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(email);

		if (matcher.matches() && password.length() > 5) {
			return "login";
		}

		else {
			model.put("error", "Please check the email format Provided");

			if (password.length() < 5)
				model.put("error", "Password length must be > 5");
			return "register";
		}
	}

	@RequestMapping("/login")
	public String login(Map<String, Object> model) {
		return "login";
	}

	@RequestMapping("/userLogin")
	public String userLogin(Map<String, Object> model, @RequestParam("email") String email,
			@RequestParam("password") String password) {

		List<User> users = userRepository.getUserByEmail(email, password);
		if (users.size() >= 1 && users.get(0) != null) {
			System.out.println(users.get(0));

			loggedUser = users.get(0);
			return "dash";
		} else {
			model.put("errorMessage", "Invalid Credentials provided");
			return "login";
		}
	}

	@PostConstruct
	public void addAll() {
		List<Item> itemList = new ArrayList<>();

		itemList.add(new Item(1, "Plant", "Marigold", 65.53, 20));
		itemList.add(new Item(2, "Plant", "Pansi", 150.43, 254));
		itemList.add(new Item(3, "Seed", "Gazania", 54.00, 24));

		itemList.add(new Item(4, "Tawa", "Earthen Tawa ", 465.56, 140));
		itemList.add(new Item(5, "Pot", "Earhen Pot Small", 50.454, 14));
		itemList.add(new Item(6, "Cups", "Earthen Tea Cup", 44.00, 54));

		itemRepository.saveAll(itemList);
	}

}