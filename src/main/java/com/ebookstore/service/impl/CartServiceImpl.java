package com.ebookstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebookstore.dao.CartDao;
import com.ebookstore.model.Cart;
import com.ebookstore.service.CartService;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartDao cartDao;

	@Override
	public void deleteCart(int cartId) {
		// TODO Auto-generated method stub
		cartDao.deleteCart(cartId);
	}

	@Override
	public Cart updateCart(int cartId, Cart cart) {
		// TODO Auto-generated method stub
		cartDao.updateCart(cartId, cart);
		return null;
	}

	@Override
	public Cart getCartById(int cartId) {
		// TODO Auto-generated method stub
		Cart myCart = cartDao.getCartById(cartId);
		return myCart;
	}

}
