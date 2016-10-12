package com.ebookstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebookstore.dao.CustomerDao;
import com.ebookstore.model.Customer;
import com.ebookstore.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;	
	
	@Override
	public Customer getCustomerById(int id) {
		
		Customer customer = customerDao.getCustomerById(id);
		return customer;
	}

	@Override
	public void addCustomer(Customer customer) {	
		// TODO Auto-generated method stub
		customerDao.addCustomer(customer);		
	}

	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer getCustomerByuserName(String userName) {
		// TODO Auto-generated method stub
		Customer customer = customerDao.getCustomerByuserName(userName);
		return customer;
	}

	
}
