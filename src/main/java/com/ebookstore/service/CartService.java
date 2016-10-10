package com.ebookstore.service;

import com.ebookstore.model.Cart;

public interface CartService {
	
public Cart createCart(Cart cart);
public void deleteCart(int cartId);
public Cart updateCart(int cartId, Cart cart);
public Cart getCartById(int cartId);

}
