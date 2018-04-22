package com.users;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.exceptions.UserException;

public class User {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private boolean isMale;
	private Date dateOfBirth;
	private List orders;
	
	
	public User(int id, String firstName, String lastName, String email, String password, boolean isMale,
			Date dateOfBirth) throws UserException {
		this.id = id;
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setPassword(password);
		this.isMale = isMale;
		this.dateOfBirth = dateOfBirth;
		this.orders = new ArrayList<Order>();
	}
	public User(String firstName, String lastName, String email, String password) throws UserException {
		this.id = id;
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setPassword(password);
		this.orders = new ArrayList<Order>();
	}
	

	public int getId() {
		return id;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) throws UserException {
		if (firstName != null && firstName.trim().length() > 0) {
			this.firstName = firstName;
		} else
			throw new UserException("invalid name");
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) throws UserException {
		if (lastName != null && lastName.trim().length() > 0) {
			this.lastName = lastName;
		} else
			throw new UserException("invalid name");
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws UserException {
		if (email != null && email.trim().length() > 0) {
			this.email = email;
		} else
			throw new UserException("invalid email");
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) throws UserException {
		if (password != null && password.trim().length() > 0) {
			this.password = password;
		} else
			throw new UserException("invalid password");
	}

	public boolean isMale() {
		return isMale;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
	
	
	
}
