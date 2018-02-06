package com.techelevator.model;

public class CartItemGroup {
	
	public String Product;
	public int Quantity;
	public double Price;
	
	
	public CartItemGroup(String product, int quantity, double price) {
		this.Product = product;
		this.Quantity = quantity;
		this.Price = price;
	}
	public String getProduct() {
		return Product;
	}
	public void setProduct(String product) {
		Product = product;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	
}
