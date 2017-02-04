/**
 * 
 */
package com.ebookstore.dao;

import com.ebookstore.model.Users;

/**
 * @author Charat Kakkar
 *
 */
public interface UserDao {
	
	public Users getUserbyUsername (String userName);

}
