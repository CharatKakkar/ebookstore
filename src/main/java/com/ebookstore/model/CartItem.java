package com.ebookstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	private Cart cart;
	
	int qty;
	double itemTotal;
	
	CartItem(){
		//Default Constructor
	}
	
	public CartItem(Product product){	
		this.product= product;
		qty= 1;
		itemTotal= product.getProductPrice()*qty;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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
