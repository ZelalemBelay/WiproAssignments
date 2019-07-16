package assignment_1;

import java.io.Serializable;

class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	String pId;
	float cost;
	int noOfItems;

	public Product() {
		super();
	}

	public Product(String pId, float cost, int noOfItems) {
		super();
		this.pId = pId;
		this.cost = cost;
		this.noOfItems = noOfItems;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public int getNoOfItems() {
		return noOfItems;
	}

	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}

}