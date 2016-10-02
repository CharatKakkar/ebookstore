package com.ebookstore.dao;

import com.ebookstore.model.Cart;

public interface CartDao {

public Cart createCart(Cart cart);
public void deleteCart(String cartId);
public Cart updateCart(String cartId, Cart cart);
public Cart getCart(String cartId);
}
