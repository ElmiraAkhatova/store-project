package com.techelevator.model;

public class Size {
	
	public int sizeId;
	public String sizeName;
	
	public Size(int sizeId, String sizeName){
		this.sizeId = sizeId;
		this.sizeName = sizeName;
	}
	
	public int getSizeId() {
		return sizeId;
	}
	public void setSizeId(int sizeId) {
		this.sizeId = sizeId;
	}
	public String getSizeName() {
		return sizeName;
	}
	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}

}
