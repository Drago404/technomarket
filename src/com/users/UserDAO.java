package com.users;

import java.sql.SQLException;

import com.exceptions.UserException;

public interface UserDAO {
	
	 boolean register(User user) throws UserException, SQLException;

	boolean checkIfUserExists(User user) throws UserException, SQLException;
	
	boolean login(String email, String password) throws SQLException;

}
