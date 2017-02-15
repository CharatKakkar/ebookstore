package com.ebookstore.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ebookstore.dao.CustomerDao;
import com.ebookstore.dao.UserDao;
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

	@Autowired
	UserDao userDao;

	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Customer customer = (Customer) session.get(Customer.class, id);
		session.flush();
		System.out.println("Get Customerby Id is being called");
		return customer;

	}

	public Customer getCurrentCustomer(){
		
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	   //  String name = auth.getName(); //get logged in username
	    return getCustomerByuserName(auth.getName());
		
	}
	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();

		// Setting the user active to be true
		customer.setIsActive(true);

		// Hashing the password

		customer.setPassword(passwordEncoder.encode(customer.getPassword()));

		// Setting the billingAddress
		BillingAddress billingAddress = (BillingAddress) customer.getBillingAddress();
		billingAddress.setCustomer(customer);
		session.saveOrUpdate(billingAddress);

		// Setting the shippingAddress
		ShippingAddress shippingAddress = (ShippingAddress) customer.getShippingAddress();
		if (shippingAddress.getState().equals("") || shippingAddress.getCountry().equals("")) {
			System.out.println("Setting shipping address from billing address");
			shippingAddress.setApartmentNumber(billingAddress.getApartmentNumber());
			shippingAddress.setStreetAddress(billingAddress.getStreetAddress());
			shippingAddress.setCity(billingAddress.getCity());
			shippingAddress.setState(billingAddress.getState());
			shippingAddress.setCountry(billingAddress.getCountry());
			shippingAddress.setZipCode(billingAddress.getZipCode());
		}
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
		Customer customer = (Customer) session.get(Customer.class, id);
		session.delete(customer);
		session.flush();
	}

	@Override
	public void modifyCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Users myUser = userDao.getUserbyUsername(customer.getUserName());
		myUser.setPassword(customer.getPassword());
		// BillingAddress billingAddress = (BillingAddress)
		// customer.getBillingAddress();
		// billingAddress.setCustomer(customer);
		// session.saveOrUpdate(billingAddress);
		session.saveOrUpdate(myUser);
		session.saveOrUpdate(customer);
		session.flush();
	}

	@Override
	public Customer getCustomerByuserName(String userName) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Customer where username = ?").setString(0, userName);
		Customer customer = (Customer) query.uniqueResult();
		session.flush();
		return customer;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Customer");
		List<Customer> listOfCustomers = query.list();
		return listOfCustomers;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ebookstore.dao.CustomerDao#isCustomerExists(java.lang.String)
	 */
	@Override
	public boolean isCustomerExists(String userName) {
		boolean isUsernameValid = false;
		if (getCustomerByuserName(userName) != null) {
			isUsernameValid = true;
		}
		return isUsernameValid;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ebookstore.dao.CustomerDao#updateCustomerInfo(com.ebookstore.model.
	 * Customer)
	 */
	@Override
	public Customer updateCustomerInfo(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		Customer myCustomer = getCustomerByuserName(customer.getUserName());
		myCustomer.setConfirmPassword(myCustomer.getPassword());
		//myCustomer.getBillingAddress().setState(customer.getBillingAddress().getState());
		BillingAddress billingAddress = (BillingAddress) myCustomer.getBillingAddress();
		
		billingAddress.setApartmentNumber(customer.getBillingAddress().getApartmentNumber());
		billingAddress.setStreetAddress(customer.getBillingAddress().getStreetAddress());
		billingAddress.setCity(customer.getBillingAddress().getCity());
		billingAddress.setState(customer.getBillingAddress().getState());
		billingAddress.setCountry(customer.getBillingAddress().getCountry());
		billingAddress.setZipCode(customer.getBillingAddress().getZipCode());		
		
		
		ShippingAddress shippingAddress = (ShippingAddress) myCustomer.getShippingAddress();
		
		
		shippingAddress.setApartmentNumber(customer.getShippingAddress().getApartmentNumber());
		shippingAddress.setStreetAddress(customer.getShippingAddress().getStreetAddress());
		shippingAddress.setCity(customer.getShippingAddress().getCity());
		shippingAddress.setState(customer.getShippingAddress().getState());
		shippingAddress.setCountry(customer.getShippingAddress().getCountry());
		shippingAddress.setZipCode(customer.getShippingAddress().getZipCode());
//		myCustomer.setBillingAddress(billingAddress);
//		myCustomer.setShippingAddress(shippingAddress);
		//billingAddress.setCustomer(myCustomer);
		session.saveOrUpdate(billingAddress);
//		shippingAddress.setCustomer(myCustomer);
		session.saveOrUpdate(shippingAddress);

		return myCustomer;
	}

}
