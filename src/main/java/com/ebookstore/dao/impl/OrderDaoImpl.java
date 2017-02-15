/**
 * 
 */
package com.ebookstore.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ebookstore.dao.OrderDao;
import com.ebookstore.model.Orders;

/**
 * @author Charat Kakkar
 *
 */
@Repository
@Transactional
public class OrderDaoImpl implements OrderDao {

	/* (non-Javadoc)
	 * @see com.ebookstore.dao.OrderDao#saveOrder()
	 */
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void saveOrder(Orders order) {
		System.out.println("CUSTOMER ID IS "+order.getCart().getCustomer().getCustomerId());
		order.setBillingAddress(order.getCart().getCustomer().getBillingAddress());
		order.setShippingAddress(order.getCart().getCustomer().getShippingAddress());
		order.setCustomer(order.getCart().getCustomer());
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(order);
		session.flush();
	}
	/* (non-Javadoc)
	 * @see com.ebookstore.dao.OrderDao#getOrder(int)
	 */
	@Override
	public Orders getOrder(int orderId) {
		Session session = sessionFactory.getCurrentSession();
		Orders order = (Orders) session.get(Orders.class,orderId);
		session.flush();
		return order;
	}

	
}
