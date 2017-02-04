/**
 * 
 */
package com.ebookstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebookstore.dao.OrderDao;
import com.ebookstore.model.Orders;
import com.ebookstore.service.OrderService;

/**
 * @author Charat Kakkar
 *
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDao orderDao;
	/* (non-Javadoc)
	 * @see com.ebookstore.service.OrderService#saveOrder(com.ebookstore.model.Orders)
	 */
	@Override
	public void saveOrder(Orders order) {
		orderDao.saveOrder(order);
		
	}

	/* (non-Javadoc)
	 * @see com.ebookstore.service.OrderService#getOrder(int)
	 */
	@Override
	public Orders getOrder(int orderId) {
		orderDao.getOrder(orderId);
		return null;
	}

	
}
