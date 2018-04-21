package com.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.DBConnection;

public class ItemDAO {

	private static final String SHOW_ALL_ITEMS_BY_CATEGORY = "SELECT * FROM items WHERE category_id = ?";
	private Connection conn;

	public ItemDAO() throws SQLException {
		this.conn = DBConnection.getInstance().getConnection();
	}

	public List<Item> itemsByCategory(Category category) throws SQLException {
		int categoryID = category.getId();
		PreparedStatement stmt = conn.prepareStatement(SHOW_ALL_ITEMS_BY_CATEGORY);
		stmt.setInt(1, category.getId());
		ResultSet rs = stmt.executeQuery();

		List<Item> itemsList = new ArrayList<Item>();

		while (rs.next()) {
			Item item = new Item();
			item.setId(rs.getInt("id"));
			item.setName(rs.getString("name"));
			item.setPrice(rs.getFloat("price"));
			item.setDescription(rs.getString("description"));
			item.setQuantity(rs.getInt("quantity"));
			itemsList.add(item);
		}
		stmt.close();
		
		return itemsList;

	}

}
