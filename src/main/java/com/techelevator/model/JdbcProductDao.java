package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcProductDao implements ProductDao {
	
	private JdbcTemplate jdbcTemplate;
		
	@Autowired
	public JdbcProductDao(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	@Override
	public List<Product> getAllProducts() {
		ArrayList<Product> allProducts = new ArrayList<>();
		
		String sqlSelectAllProducts="SELECT * FROM products";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet( sqlSelectAllProducts);
		
		while(results.next()) {
			
			Product item = mapRowToProduct(results);
			
			allProducts.add(item);
		}
		return allProducts;
	}

	@Override
	public void save(Product product) {
		Long id = getNextId();
		String sqlInsertPost = "INSERT INTO products(id, sellerId, title, category, condition, color, size, price, imgUrl ) VALUES (?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sqlInsertPost, id, 1L/*product.getSellerId()*/, product.getTitle(), product.getCategory(), product.getCondition(), product.getColor(), product.getSize(), product.getPrice(), product.getImgUrl());
	}
	
	@Override
	public Product getProductById(Long id) {
		Product product = new Product();
		
		String sqlQuery = "SELECT * FROM products WHERE id=?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery, id);
		
		if(results.next()) {
			product = mapRowToProduct(results);
		}
		return product;
	}
	
	private Product mapRowToProduct(SqlRowSet results) {
		Product product;
		Long productId = results.getLong("id");
		Long sellerId = results.getLong("sellerId");
		String title = results.getString("title");
		String category = results.getString("category");
		String condition = results.getString("condition");
		String color = results.getString("color");
		String size = results.getString("size");
		double price = results.getDouble("price");
		String imgUrl = results.getString("imgUrl");
		
		product = new Product(productId, sellerId, title, category, condition, color, size, price, imgUrl);
		return product;
	}

	private Long getNextId() {
		String sqlSelectNextId = "SELECT NEXTVAL('seq_product_id')";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectNextId);
		Long id = null;
		if(results.next()) {
			id = results.getLong(1);
		} else {
			throw new RuntimeException("Something strange happened, unable to select next product id from sequence");
		}
		return id;
	}
	

	
	
}
