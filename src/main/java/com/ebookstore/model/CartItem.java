package com.ebookstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CartItem {
	@Id
    @GeneratedValue
    private int cartItemId;
	
	@ManyToOne
	@JoinColumn(name="productId")
	Product product;
	
	@ManyToOne
	@JoinColumn(name="cartId")
	 @JsonIgnore
	private Cart cart;
	
	int qty;
	
	double itemTotal;
	
	public CartItem(){
		//Default Constructor
	}
	
//	public CartItem(Product product){	
//		this.product= product;
//		qty= 1;
//		itemTotal= product.getProductPrice()*qty;
//	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getItemTotal() {
		return itemTotal;
	}

	public void setItemTotal(double itemTotal) {
		this.itemTotal = itemTotal;
	}


}
