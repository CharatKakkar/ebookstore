/**
 * 
 */
package com.ebookstore.service;

import com.ebookstore.model.Orders;

/**
 * @author Charat Kakkar
 *
 */
public interface OrderService {
	
	public void saveOrder(Orders order);
	
	public Orders getOrder(int orderId);

}
