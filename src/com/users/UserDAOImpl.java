package com.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.db.DBConnection;
import com.exceptions.UserException;

public class UserDAOImpl implements UserDAO {
	
	private	static final String INSERT_USER = "insert into users(id,first_name,last_name,email,password,is_male,date_of_birth) "
			+ "values (null, ?, ?, ?, ?, ?, ?)";
	private static final String CHECK_USER_IF_EXISTS = "select * from users where email =?";
	private Connection conn;
	
	public UserDAOImpl() throws SQLException{
		this.conn = DBConnection.getInstance().getConnection();
	}

	
	@Override
	public void register(User user) throws UserException, SQLException {
        PreparedStatement  stmt = conn.prepareStatement(INSERT_USER);
        if(!checkIfUserExists(user)) {
        stmt.setString(2, user.getFirstName());
        stmt.setString(3, user.getLastName());
        stmt.setString(4, user.getEmail());
        stmt.setString(5, user.getPassword());
        stmt.setBoolean(6, user.isMale());
        stmt.setDate(7, user.getDateOfBirth());
        stmt.executeUpdate();
        }
        else throw new UserException("User already exists");
    
        stmt.close();
	}
	
	
	@Override
    public boolean checkIfUserExists(User user) throws UserException, SQLException {
		 PreparedStatement  stmt = conn.prepareStatement(CHECK_USER_IF_EXISTS);
		 stmt.setString(1, user.getEmail());
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			stmt.close();
			return false;
		}
			stmt.close();
			return true;
}
	
}
