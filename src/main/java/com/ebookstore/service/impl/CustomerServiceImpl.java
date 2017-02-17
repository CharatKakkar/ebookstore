package com.ebookstore.service.impl;

import java.util.List;

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
	public Customer getCurrentUser(){
		return customerDao.getCurrentCustomer();
	}
	@Override
	public void modifyCustomer(Customer customer) {
		customerDao.modifyCustomer(customer);

	}

	@Override
	public Customer getCustomerByuserName(String userName) {
		// TODO Auto-generated method stub
		Customer customer = customerDao.getCustomerByuserName(userName);
		return customer;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		List<Customer> listOfCustomers = customerDao.getAllCustomers();
		return listOfCustomers;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ebookstore.service.CustomerService#isCustomerExists(java.lang.String)
	 */
	@Override
	public boolean isCustomerExists(String userName) {

		return customerDao.isCustomerExists(userName);
	}

	/* (non-Javadoc)
	 * @see com.ebookstore.service.CustomerService#updateCustomerInfo(com.ebookstore.model.Customer)
	 */
	@Override
	public Customer updateCustomerInfo(Customer customer) {
		
		return customerDao.updateCustomerInfo(customer);
	}

}
