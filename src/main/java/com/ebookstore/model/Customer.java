package com.ebookstore.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Customer implements Serializable{

	private static final long serialVersionUID = -3730131383483092726L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int customerId;
	
	@NotEmpty
	@Min(value = 4, message = "The username that you have entered is less than 4 Characters. Please enter a username with at least 4 Characters")
	private String userName;
	
	@NotEmpty
	@Min(value = 4, message = "The password that you have entered is less than 6 Characters. Please enter a password with at least 6 Characters")
	private String password;
	
	@NotNull
	@NotEmpty(message="EmailId cannot be null")
	private String emailId;
	
	
	private boolean isActive;
	
	@OneToOne
	@JoinColumn(name= "billingAddressId")
	private BillingAddress billingAddress;
	
	@OneToOne
	@JoinColumn(name= "shippingAddressId")
	private ShippingAddress shippingAddress;
	
	@OneToOne
	@JoinColumn(name="cartId")
	@JsonIgnore
	private Cart cart;
	
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
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

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart carId) {
		this.cart = carId;
	}
	

}
