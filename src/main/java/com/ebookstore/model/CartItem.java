package com.ebookstore.model;

public class CartItem {
	
	

	Product product;
	int qty;
	double itemTotal;
	
	CartItem(){
		//Default Constructor
	}
	
	CartItem(Product product){
	
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
