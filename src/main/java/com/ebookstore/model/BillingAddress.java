package com.ebookstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class BillingAddress {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int billingAddressId;
	
	@NotEmpty(message="streetAddress cannot be null")
	private String streetAddress;
	
	@NotEmpty(message="apartmentNumber cannot be null")
	private int apartmentNumber;
	
	@NotEmpty(message="zipCode cannot be null")
	private String zipCode;
	
	@NotEmpty(message="State cannot be null")
	private String State;
	
	@NotEmpty(message="Country cannot be null")
	private String Country;
	
	
	@OneToOne
	private Customer customer;
	int getBillingAddressId() {
		return billingAddressId;
	}

	public void setBillingAddressId(int billingAddressId) {
		this.billingAddressId = billingAddressId;
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

	
	@Override
	public String toString() {
		return "BillingAddress [billingAddressId=" + billingAddressId + ", streetAddress=" + streetAddress
				+ ", apartmentNumber=" + apartmentNumber + ", zipCode=" + zipCode + ", State=" + State + ", Country="
				+ Country + "]";
	}
	
	
	
}
