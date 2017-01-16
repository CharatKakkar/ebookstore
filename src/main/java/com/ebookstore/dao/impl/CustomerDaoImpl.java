package com.ebookstore.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.ebookstore.dao.CustomerDao;
import com.ebookstore.model.Authorities;
import com.ebookstore.model.BillingAddress;
import com.ebookstore.model.Cart;
import com.ebookstore.model.Customer;
import com.ebookstore.model.ShippingAddress;
import com.ebookstore.model.Users;
@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		Session session= sessionFactory.getCurrentSession();	
		Customer customer = (Customer)session.get(Customer.class, id);
		session.flush();		
		return customer;
	}

	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();

		//Setting the user active to be true
		customer.setIsActive(true);
		
		// Hashing the password
		
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));

		// Setting the billingAddress
		BillingAddress billingAddress = (BillingAddress) customer.getBillingAddress();
		billingAddress.setCustomer(customer);
		session.saveOrUpdate(billingAddress);

		// Setting the shippingAddress
		ShippingAddress shippingAddress = (ShippingAddress) customer.getShippingAddress();
		shippingAddress.setCustomer(customer);
		session.saveOrUpdate(shippingAddress);
		session.saveOrUpdate(customer);

		// Saving the userObject
		Users newUser = new Users();
		newUser.setUsername(customer.getUserName());
		newUser.setPassword(customer.getPassword());
		newUser.setActive(true);
		newUser.setCustomerId(customer.getCustomerId());
		session.saveOrUpdate(newUser);

		// Saving the Authorities
		Authorities newAuthority = new Authorities();
		newAuthority.setUserName(customer.getUserName());
		newAuthority.setAuthority("ROLE_USER");
		session.saveOrUpdate(newAuthority);

		// Kuch to set karunga ab
		// saving the cartObject
		Cart myCart = new Cart();
		myCart.setCustomer(customer);
		customer.setCart(myCart);
		session.saveOrUpdate(myCart);

	}

	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Customer customer=(Customer)session.get(Customer.class, id);
		session.delete(customer);
		session.flush();		
	}

	@Override
	public void modifyCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer getCustomerByuserName(String userName) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Customer where username = ?").setString(0, userName);
		Customer customer = (Customer) query.uniqueResult();
		session.flush();
		return customer ;		
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Customer");
		List<Customer> listOfCustomers = query.list();
		return listOfCustomers;
	}

}
