/**
 * 
 */
package com.ebookstore.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ebookstore.dao.UserDao;
import com.ebookstore.model.Users;

/**
 * @author Charat Kakkar
 *
 */

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	/* (non-Javadoc)
	 * @see com.ebookstore.dao.UserDao#getUserbyUsername(java.lang.String)
	 */

	@Autowired
	SessionFactory sessionFactory;
	@Override
	public Users getUserbyUsername(String userName) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Users where username = ?").setString(0, userName);
		Users users = (Users) query.uniqueResult();
		session.flush();
		System.out.println("username is " + users.getUsername());
		return users ;	
		
	}

}
