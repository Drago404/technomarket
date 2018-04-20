package com.users;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {
	
	private int id;
	private String firstName;
	private String secondName;
	private String email;
	private String password;
	private boolean isMale;
	private LocalDate dateOfBirth;
	private List orders;
	
	
	public User(int id, String firstName, String secondName, String email, String password, boolean isMale,
			LocalDate dateOfBirth) {
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
		this.email = email;
		this.password = password;
		this.isMale = isMale;
		this.dateOfBirth = dateOfBirth;
		this.orders = new ArrayList<Order>();
	}
	

	public int getId() {
		return id;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isMale() {
		return isMale;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
	
	
	
}
