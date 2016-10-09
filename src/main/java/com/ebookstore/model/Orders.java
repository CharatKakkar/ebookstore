package com.ebookstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Orders {
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Cart getCarId() {
		return carId;
	}

	public void setCarId(Cart carId) {
		this.carId = carId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderId;
	
	@OneToOne
	@JoinColumn(name="cardId")
	@JsonIgnore
	private Cart carId;
	
	@OneToOne
	@JoinColumn(name="customerId")
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name= "BillingAddress")
	private BillingAddress billingAddress;
	
	@OneToOne
	@JoinColumn(name= "shippingAddressId")
	private ShippingAddress shippingAddress;
	

}
