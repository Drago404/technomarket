package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.db.DBConnection;

public class CategoryDAO {
	
	private static final String ALL_CATEGORIES = "select name, category_id from category";
	private static HashMap<String, Integer> allCategories = new HashMap<>();
	private Connection conn;
	private static CategoryDAO cat;
	
	private CategoryDAO() throws SQLException {
		this.conn = DBConnection.getInstance().getConnection();
	}
	
	
	public synchronized HashMap<String, Integer> getAllCategories() {
		if (allCategories.isEmpty()) {
			try {
				PreparedStatement stmt = conn.prepareStatement(ALL_CATEGORIES);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					String name = rs.getString("name");
					int categoryId = rs.getInt("category_id");

					allCategories.put(name, categoryId);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return allCategories;
	}
	
	
	public static CategoryDAO getInstance() throws SQLException {
		if (cat == null) {
			cat = new CategoryDAO();
		}
		return cat;
	}

}
