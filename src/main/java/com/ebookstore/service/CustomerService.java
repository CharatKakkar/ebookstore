package com.ebookstore.service;

import com.ebookstore.model.Customer;

public interface CustomerService {
	
	Customer getCustomerById(int id);

	void addCustomer(Customer customer);

	void deleteCustomer(Customer customer);

	void modifyCustomer(Customer customer);

	Customer getCustomerByuserName(String userName);
    
   }
