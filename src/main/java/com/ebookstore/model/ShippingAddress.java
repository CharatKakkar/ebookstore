package com.ebookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class ShippingAddress {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	String shippingAddressId;
	
	

	@NotEmpty(message="streetAddress cannot be null")
	String streetAddress;
	
	@NotEmpty(message="apartmentNumber cannot be null")
	int apartmentNumber;
	
	@NotEmpty(message="zipCode cannot be null")
	String zipCode;
	
	@NotEmpty(message="State cannot be null")
	String State;
	
	@NotEmpty(message="Country cannot be null")
	String Country;
	
	@OneToOne
	Customer customer;

	public String getShippingAddressId() {
		return shippingAddressId;
	}

	public void setShippingAddressId(String shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public int getApartmentNumber() {
		return apartmentNumber;
	}

	public void setApartmentNumber(int apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	@Override
	public String toString() {
		return "BillingAddress [shippingAddressId=" + shippingAddressId + ", streetAddress=" + streetAddress
				+ ", apartmentNumber=" + apartmentNumber + ", zipCode=" + zipCode + ", State=" + State + ", Country="
				+ Country + "]";
	}

}
