package com.ebookstore.dao;

import com.ebookstore.model.Cart;

public interface CartDao {

public Cart createCart(Cart cart);
public Cart getCartById(int cartId);
public Cart updateCart(int cartId, Cart cart);
public void deleteCart(int cartId);
}
