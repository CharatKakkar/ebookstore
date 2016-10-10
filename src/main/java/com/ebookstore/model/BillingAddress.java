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
	
	
	private String streetAddress;

	private int apartmentNumber;
	
	
	private String zipCode;
	
	
	private String city;
	
	
	private String state;
	
	
	private String Country;
	
	
	@OneToOne
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

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
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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
				+ ", apartmentNumber=" + apartmentNumber + ", zipCode=" + zipCode + ", State=" + city + ", Country="
				+ Country + "]";
	}
	
	
	
}
