package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	
	public List<ShoppingCartItem> items = new ArrayList<>();

	public List<ShoppingCartItem> getItems() {
		return items;
	}
	
	
	public ShoppingCartItem getItemByProductId(Long productId) {
		ShoppingCartItem matchingItem = new ShoppingCartItem();
		for(ShoppingCartItem cartItem : this.items) {
			if(cartItem.getProduct().getId() == productId) {
				matchingItem = cartItem;
			}
		}
		
		return matchingItem;
	}

	public void setItems(List<ShoppingCartItem> items) {
		this.items = items;
	}
	
	public void empty() {
		items.clear();
	}
    
    /**
     *  Adds a product to the shopping cart. If it is already in the cart, updates the quantity.
     * @param product
     * @param quantity
     */
	public void addToCart(Product product, int quantity) {
		ShoppingCartItem existingItem = null;
		for (ShoppingCartItem item : items) {
			if (item.getProduct().getId().equals(product.getId())) {
				existingItem = item;
				break;
			}
		}
		if (existingItem == null) {
			items.add(new ShoppingCartItem(product, quantity));
		} else {
			existingItem.setQuantity(existingItem.getQuantity() + quantity);
		}
	}

    /**
     * Get the subtotal of all items in the shopping cart.
     */
	public double getSubTotal() {
		double subTotal = 0;
		for (ShoppingCartItem item : items) {
			subTotal = subTotal+(item.getPrice());
		}
		return subTotal;
	}
	
	//Update quantity for an item already in the shopping cart
	public void updateItemQuantity(Long productId, int quantity) {
		for(ShoppingCartItem item : items){
			if(productId == item.getProduct().getId()) {
				item.setQuantity(quantity);
			}
		}
	}

	//remove item from shopping cart
	public void removeItem(Long productId) {
		ShoppingCartItem itemToRemove = new ShoppingCartItem();
		for(ShoppingCartItem item : items) {
			if(item.getProduct().getId() == productId) {
				itemToRemove=item;
			}
		}
		items.remove(itemToRemove);
	}
}

