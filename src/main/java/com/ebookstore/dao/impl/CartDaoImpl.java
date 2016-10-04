package com.ebookstore.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ebookstore.dao.CartDao;
import com.ebookstore.model.Cart;

@Repository
public class CartDaoImpl implements CartDao {

	public Map<String, Cart> cartsList;

	public CartDaoImpl() {
		cartsList = new HashMap<String, Cart>();
	}

	@Override
	public Cart createCart(Cart cart) {
		// TODO Auto-generated method stub
		String cartId = cart.getCartId();
		if (cartsList.keySet().contains(cartId)) {
			throw new IllegalArgumentException(String.format("Cart already exists"));
		} else {
			cartsList.put(cart.getCartId(), cart);
		}
		return cart;
	}

	@Override
	public void deleteCart(String cartId) {
		// TODO Auto-generated method stub
		if (cartsList.keySet().contains(cartId)) {
			cartsList.remove(cartId);
		} else {

			throw new IllegalArgumentException(String.format("Cart doesn't  exist"));
		}

	}	

	@Override
	public Cart updateCart(String cartId, Cart cart) {
		// TODO Auto-generated method stub
		if (cartsList.keySet().contains(cartId)) {
			cartsList.put(cartId, cart);
			
		} else {
			throw new IllegalArgumentException(String.format("Cart doesn't exist"));
		}
		return cart;
	}

	@Override
	public Cart getCart(String cartId) {
		// TODO Auto-generated method stub
		Cart myCart = null;
		if (cartsList.keySet().contains(cartId))  {
			myCart = cartsList.get(cartId);
		} 
		/*else {
			throw new IllegalArgumentException(
					String.format("Invalid Cart Id so cannot return cart from getCart Function"));
		}
		*/
		return myCart;
	}

}
