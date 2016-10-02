package com.ebookstore.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

	
	String cartId;
	Map <Integer, CartItem> cartItems ;
	double grandTotal;
	
	public Cart(){
		grandTotal = 0;
		new HashMap<Integer,CartItem>();
	}

	Cart(String cartId){
		this.cartId=cartId; 
	}
	
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public Map<Integer, CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(Map<Integer, CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	public double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public void addCartItem(CartItem item) {
		int productId = item.getProduct().getProductId();
		if (cartItems.containsKey(productId)) {
			CartItem oldItem = cartItems.get(productId);
			oldItem.setQty(oldItem.getQty() + item.getQty());
			cartItems.put(productId, oldItem);
			updategrandTotal();
		} else {
			cartItems.put(productId, item);
			updategrandTotal();
		}
	}// addCartItem ends

	public void deleteCartItem(CartItem item) {
		int productId = item.getProduct().getProductId();
		if (!cartItems.containsKey(productId)) {
			throw new IllegalArgumentException(String.format("Wrong item sent to delete"));
		} else {
			cartItems.remove(productId);
			updategrandTotal();
		}
	}//deleteCartItem Ends
	
	public double updategrandTotal() {
		grandTotal = 0;

		for (CartItem items : cartItems.values()) {
			grandTotal = grandTotal + items.getItemTotal();
		}
		return grandTotal;
	}

}
