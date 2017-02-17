package com.ebookstore.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer implements Serializable {

	private static final long serialVersionUID = -3730131383483092726L;
	
	@Transient
	private Boolean conditionTrue = Boolean.FALSE;
	@Transient
	private Boolean containsUsername = Boolean.TRUE;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	
	@Size(min = 6, message = "Please enter a username with at least 6 Characters")
	private String userName;

	@Size(min = 6, message = "Please enter a password with at least 6 Characters")
	private String password;

	@Transient
	private String confirmPassword;

	private String emailId;

	private boolean isActive;
	
	@Size(min=6,message="")
	private String securityPhrase;
		
	@OneToOne
	@JoinColumn(name = "billingAddressId")
	private BillingAddress billingAddress;

	@OneToOne
	@JoinColumn(name = "shippingAddressId")
	private ShippingAddress shippingAddress;

	@OneToOne
	@JoinColumn(name = "cartId")
	@JsonIgnore
	private Cart cart;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	@AssertTrue(message = "Password containing username is not allowed")
	public Boolean isContainsUsername() {
		if (this.password.toLowerCase().contains(this.userName.toLowerCase())) {
			containsUsername = Boolean.FALSE;
		}
		return containsUsername;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public Boolean getContainsUsername() {
		return containsUsername;
	}

	public void setContainsUsername(Boolean containsUsername) {
		this.containsUsername = containsUsername;
	}

	@AssertTrue(message = "Password mismatch")
	public Boolean isConditionTrue() {
		if (this.password.equals(this.confirmPassword)) {
			conditionTrue = Boolean.TRUE;
		}
		return conditionTrue;
	}

	public Boolean getconditionTrue() {
		return conditionTrue;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setConditionTrue(boolean conditionTrue) {
		this.conditionTrue = conditionTrue;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getSecurityPhrase() {
		return securityPhrase;
	}

	public void setSecurityPhrase(String securityPhrase) {
		this.securityPhrase = securityPhrase;
	}

}
