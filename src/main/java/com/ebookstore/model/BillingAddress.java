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
	
	@NotEmpty(message="Please enter your Street number")
	private String streetAddress;

	@NotEmpty(message="Please enter your Apartment number")
	//change from int to Integer since int will be initialized to 0
	private Integer apartmentNumber;
	
	@NotEmpty(message="Please enter your Zip code")
	private String zipCode;
	
	@NotEmpty(message="Please enter your city")
	private String city;
	
	@NotEmpty(message="Please enter your State")
	private String state;
	
	@NotEmpty(message="Please enter your Country")
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

	public Integer getApartmentNumber() {
		return apartmentNumber;
	}

	public void setApartmentNumber(Integer apartmentNumber) {
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
