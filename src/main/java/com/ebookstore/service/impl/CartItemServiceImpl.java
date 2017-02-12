package com.ebookstore.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebookstore.dao.CartItemDao;
import com.ebookstore.model.Cart;
import com.ebookstore.model.CartItem;
import com.ebookstore.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService{
	
	@Autowired
	CartItemDao cartItemDao;

	@Override
	public void addCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		cartItemDao.addCartItem(cartItem);		
	}

	@Override
	public void removeCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		cartItemDao.removeCartItem(cartItem);		
	}

	@Override
	public void removeAllCartItems(Cart cart) {
		// TODO Auto-generated method stub
		cartItemDao.removeAllCartItems(cart);
	}

	@Override
	public CartItem getCartItemByProductId(int productId, int cartId) {
		// TODO Auto-generated method stub
		CartItem myItem = cartItemDao.getCartItemByProductId(productId, cartId);
		return myItem;
	}

}
