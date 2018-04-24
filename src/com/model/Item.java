package com.model;

import com.exceptions.ItemException;

public class Item {

	private long id;
	private String name;
	private float price;
	private String description;
	private int quantity;
	private String pictureUrl;
	private long categoryId;
	

	public Item(String name, float price, String description, int quantity, String pictureUrl, long categoryId) {
		this.id = id;
		setName(name);
		setPrice(price);
		setDescription(description);
		setQuantity(quantity);
		setCategoryId(categoryId);
		this.pictureUrl = pictureUrl;
	}

	public Item() {

	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		if (name != null && name.trim().length() > 0) {
			this.name = name;
		} else
			new ItemException("invalid item name");
	}

	public void setPrice(float price) {
		if(price > 0) {
		this.price = price;
		} 
		else new ItemException("invalid price");
	}

	public void setDescription(String description) {
		if (description != null && description.trim().length() > 0) {
			this.description = description;
		} else
			new ItemException("invalid item description");
	}

	public void setQuantity(int quantity) {
		if (quantity >= 0) {
			this.quantity = quantity;
		} else
			new ItemException("invalid quantity");
	}

	public long getId() {
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

	public String getPictureUrl() {
		return pictureUrl;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

//	public void setPictureUrl(String pictureUrl) {
//		if(pictureUrl.matches("http(s?)://([\\w-]+\\.)+[\\w-]+(/[\\w- ./]*)+\\.(?:[gG][iI][fF]|[jJ][pP][gG]|[jJ][pP][eE][gG]|[pP][nN][gG]|[bB][mM][pP])")) {
//		this.pictureUrl = pictureUrl;
//	}
//		new ItemException("invalid photo URL");
//	}

}
