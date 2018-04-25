package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.db.DBConnection;
import com.model.Category;
import com.model.Item;

public class ItemDAO {

	private static final String SHOW_ALL_ITEMS_BY_CATEGORY = "SELECT * FROM items WHERE category_id = ?";
	private static final String ADD_PRODUCT = "insert into items(name,price,description,quantity,pictureUrl,category_id)"
			+ "values(?, ?, ?, ?, ?, ?) ";
	private Connection conn;
	public static  Map<Long, Item> allItems;

	public ItemDAO() throws SQLException {
		this.conn = DBConnection.getInstance().getConnection();
		allItems = new HashMap<Long, Item>();
	}

	public List<Item> itemsByCategory(Category category) throws SQLException {
		long categoryID = category.getId();
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
	
	//admin
	public void addItem(Item i) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			int categoryId = CategoryDAO.getInstance().getAllCategories().get(i.getCategoryId());
			stmt = conn.prepareStatement(ADD_PRODUCT);
			stmt.setString(1, i.getName());
			stmt.setFloat(2, i.getPrice());
			stmt.setString(3, i.getDescription());
			stmt.setInt(4, i.getQuantity());
			stmt.setString(5, i.getPictureUrl());
			stmt.setLong(6, categoryId);

			rs = stmt.getGeneratedKeys();
			rs.next();
			long primaryKey = rs.getLong(1);
			i.setId(primaryKey);
			allItems.put(primaryKey, i);
			synchronized (this) {
				stmt.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

}
