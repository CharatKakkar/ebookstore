package com.ebookstore.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.ebookstore.dao.CartDao;
import com.ebookstore.model.Cart;

public class CartDaoImpl implements CartDao {

	public Map<String, Cart> cartsList;

	public CartDaoImpl() {
		cartsList = new HashMap<String, Cart>();
	}

	@Override
	public Cart createCart(Cart cart) {
		// TODO Auto-generated method stub
		String cartId = cart.getCartId();
		if (cartsList.containsKey(cartId)) {
			throw new IllegalArgumentException(String.format("Cart already exists"));
		} else {
			cartsList.put(cart.getCartId(), cart);
		}
		return cart;
	}

	@Override
	public void deleteCart(String cartId) {
		// TODO Auto-generated method stub
		if (cartsList.containsKey(cartId)) {
			cartsList.remove(cartId);
		} else {

			throw new IllegalArgumentException(String.format("Cart already exists"));
		}

	}

	@Override
	public Cart updateCart(String cartId, Cart cart) {
		// TODO Auto-generated method stub
		if (!cartsList.containsKey(cartId)) {
			throw new IllegalArgumentException(String.format("Cart doesn't exist"));
		} else {
			cartsList.put(cartId, cart);
		}
		return cart;
	}

	@Override
	public Cart getCart(String cartId) {
		// TODO Auto-generated method stub
		Cart myCart;
		if (cartsList.containsKey(cartId)) {
			myCart = cartsList.get(cartId);
		} else {
			throw new IllegalArgumentException(
					String.format("Invalid Cart Id so cannot return cart from getCart Function"));
		}
		return myCart;
	}

}
