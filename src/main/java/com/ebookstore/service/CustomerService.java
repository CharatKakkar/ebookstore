package com.ebookstore.service;

import java.util.List;

import com.ebookstore.model.Customer;

public interface CustomerService {
	
	Customer getCustomerById(int id);

	void addCustomer(Customer customer);

	void deleteCustomer(int id);

	void modifyCustomer(Customer customer);
	
	Customer updateCustomerInfo(Customer customer);

	Customer getCustomerByuserName(String userName);
	
	boolean isCustomerExists(String userName);
	
	public Customer getCurrentUser();
	
	List <Customer> getAllCustomers();
    
   }
