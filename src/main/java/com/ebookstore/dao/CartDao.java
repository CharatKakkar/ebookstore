package com.ebookstore.dao;

import com.ebookstore.model.Cart;

public interface CartDao {

public Cart getCartById(int cartId);
public void updateCart(int cartId);
public void deleteCart(int cartId);

}
