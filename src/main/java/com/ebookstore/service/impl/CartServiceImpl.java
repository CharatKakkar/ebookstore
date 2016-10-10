package com.ebookstore.service.impl;

import com.ebookstore.dao.CartDao;
import com.ebookstore.model.Cart;
import com.ebookstore.service.CartService;

public class CartServiceImpl implements CartService{

	CartDao cartDao;
	
	@Override
	public Cart createCart(Cart cart) {
		// TODO Auto-generated method stub
		cartDao.createCart(cart);
		return null;
	}

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
		cartDao.getCartById(cartId);
		return null;
	}

}
