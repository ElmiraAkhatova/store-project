package com.techelevator.model;

public class Product {
	
	public Product() {};
  public Product(Long id, Long sellerId, String title, String category, String condition, String color, String size, double price,
			String imgUrl) {
		this.id = id;
		this.sellerId = sellerId;
		this.title = title;
		this.category = category;
		this.condition = condition;
		this.color = color;
		this.size = size;
		this.price = price;
		this.imgUrl = imgUrl;
	}
public Long id;
  public Long sellerId;
  public String title;
  public String category;
  public String condition;
  public String color;
  public String size;
  public double price;
  public String imgUrl;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Long getSellerId() {
	return sellerId;
}
public void setSellerId(Long sellerId) {
	this.sellerId = sellerId;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getCondition() {
	return condition;
}
public void setCondition(String condition) {
	this.condition = condition;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public String getSize() {
	return size;
}
public void setSize(String size) {
	this.size = size;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getImgUrl() {
	return imgUrl;
}
public void setImgUrl(String imgUrl) {
	this.imgUrl = imgUrl;
}
  
 
}
  

