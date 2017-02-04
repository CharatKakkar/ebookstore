/**
 * 
 */
package com.ebookstore.dao;

import com.ebookstore.model.Orders;

/**
 * @author Charat Kakkar
 *
 */
public interface OrderDao {

	public void saveOrder(Orders order);
	public Orders getOrder(int orderId);
	
}
