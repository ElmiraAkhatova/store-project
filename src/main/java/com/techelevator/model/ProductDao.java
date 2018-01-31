package com.techelevator.model;

import java.util.List;

public interface ProductDao {

	public List<Product> getAllProducts();

	public void save(Product product);

}
