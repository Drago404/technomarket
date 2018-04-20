package com.users;

public class Item {

	private int id;
	private String name;
	private float price;
	private String description;
	private int quantity;
	
	
	public Item(int id, String name, float price, String description, int quantity) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
	}


	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public float getPrice() {
		return price;
	}


	public String getDescription() {
		return description;
	}


	public int getQuantity() {
		return quantity;
	}
	
	
	
}
