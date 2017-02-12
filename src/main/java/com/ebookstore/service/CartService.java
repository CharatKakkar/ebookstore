package com.ebookstore.service;

import com.ebookstore.model.Cart;

public interface CartService {
	
public void deleteCart(int cartId);
public Cart updateCart(int cartId);
public Cart getCartById(int cartId);

}
