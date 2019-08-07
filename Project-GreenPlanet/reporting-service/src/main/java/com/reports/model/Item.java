package com.reports.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Item {

	@Id
	@GeneratedValue
	int id;
	
	String type;
	String description;
	double price;
	int quantity;
	double total;
	
	public Item() {
		super();
		this.total = this.quantity * this.price;
	}
	
	
	public Item(int id, String type, String description, double price, int quantity) {
		super();
		this.id = id;
		this.type = type;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		
		this.total = this.quantity * this.price;
	}



	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
