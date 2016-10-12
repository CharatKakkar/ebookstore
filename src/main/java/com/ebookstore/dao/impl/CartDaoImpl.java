package com.ebookstore.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ebookstore.dao.CartDao;
import com.ebookstore.model.Cart;

@Repository
@Transactional
public class CartDaoImpl implements CartDao {

	@Autowired
	SessionFactory sessionFactory;
	

	@Override
	public void deleteCart(int cartId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Cart cart = (Cart) session.get(Cart.class, cartId);
		session.delete(cart);
	}	

	@Override
	public Cart updateCart(int cartId, Cart cart) {
		return cart;
		// TODO Auto-generated method stub
	
	}

	@Override
	public Cart getCartById(int cartId) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.getCurrentSession();
		Cart myCart = (Cart) session.get(Cart.class, cartId);
		return myCart;
	}

	

}
