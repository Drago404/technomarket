package com.users;

public class Category {
	
	private int id;
	private String name;
	private int subcategoryID;
	
	
	public Category(int id, String name) {
		this.id = id;
		this.name = name;
	}	

	public Category(int id, String name, int subcategoryID) {
		this.id = id;
		this.name = name;
		this.subcategoryID = subcategoryID;
	}



	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public int getSubcategoryID() {
		return subcategoryID;
	}
	
	
	
	
}
