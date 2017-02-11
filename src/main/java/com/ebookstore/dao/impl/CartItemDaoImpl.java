package com.ebookstore.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ebookstore.dao.CartItemDao;
import com.ebookstore.model.Cart;
import com.ebookstore.model.CartItem;

@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao {
	 @Autowired
	    private SessionFactory sessionFactory;

	    public void addCartItem(CartItem cartItem) {
	        Session session = sessionFactory.getCurrentSession();
	        session.saveOrUpdate(cartItem);
	        session.flush();
	    }

	    public void removeCartItem (CartItem cartItem) {
	        Session session = sessionFactory.getCurrentSession();
	        session.delete(cartItem);
	        session.flush();
	    }

	    public void removeAllCartItems(Cart cart) {
	   //get the list of all the items in the cart
	    	List<CartItem> cartItems = cart.getCartItems();
	   //Iterate each on the them and remove by calling the removeCartItem method
	    	for (CartItem cartItem : cartItems )
	    	{
	    		removeCartItem(cartItem);
	    	}
	    }

	    public CartItem getCartItemByProductId (int productId) {
	        Session session = sessionFactory.getCurrentSession();
	        Query query = session.createQuery("from CartItem where productId = ?");
	        query.setInteger(0, productId);
	        session.flush();
	        
	        return (CartItem) query.uniqueResult();
	    }
	    
	    

}
