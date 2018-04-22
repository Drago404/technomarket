package com.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.db.DBConnection;
import com.exceptions.UserException;

public class UserDAOImpl implements UserDAO {
	
	private	static final String INSERT_USER = "insert into users(id,first_name,last_name,email,password) "
			+ "values (null, ?, ?, ?, sha1(?))";
	private static final String CHECK_USER_IF_EXISTS = "select * from users where email =?";
	private static final String CHECK_LOGIN = "select * from users where email=? and password=sha1(?)";
	private Connection conn;
	private List<User> users = new ArrayList<User>();
	private static UserDAOImpl userDao;
	
	
	
	private UserDAOImpl() throws SQLException{
		this.conn = DBConnection.getInstance().getConnection();
	}

	
	@Override
	public boolean register(User user) throws UserException, SQLException {
        PreparedStatement  stmt = conn.prepareStatement(INSERT_USER);
        if(checkIfUserExists(user)) {
        stmt.setString(1, user.getFirstName());
        stmt.setString(2, user.getLastName());
        stmt.setString(3, user.getEmail());
        stmt.setString(4, user.getPassword());
        stmt.executeUpdate();
        stmt.close();
        return true;
        }
      else {
        	throw new UserException("User already exists");
        	}
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
	
	@Override
	public boolean login(String email, String password) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(CHECK_LOGIN);
		stmt.setString(1, email);
		stmt.setString(2, password);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
				stmt.close();
				return true;
			}
		stmt.close();
		return false;
	}
	
	public static UserDAOImpl getInstance() throws SQLException {
		if (userDao == null) {
			userDao = new UserDAOImpl();
		}
		return userDao;
	}
	
}
