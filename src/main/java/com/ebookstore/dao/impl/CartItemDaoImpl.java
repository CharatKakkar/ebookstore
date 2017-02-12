package com.ebookstore.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ebookstore.dao.CartItemDao;
import com.ebookstore.dao.CustomerDao;
import com.ebookstore.model.Cart;
import com.ebookstore.model.CartItem;

@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao {
	 @Autowired
	    private SessionFactory sessionFactory;
	 
	 CustomerDaoImpl customerDao = new CustomerDaoImpl();

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

	    public CartItem getCartItemByProductId (int productId, int cartId) {
	        Session session = sessionFactory.getCurrentSession();
	      //  customerDao.getCustomerByuserName(userName);
	        System.out.println("This is cart ID " + cartId);
	        Query query = session.createQuery("from CartItem where productId = ? and cartId=?");
	        query.setInteger(0, productId);
	        query.setInteger(1, cartId);
	        System.out.println("product Id" + productId);
	        System.out.println("Her is the query" + query);
	        session.flush();
	        
	        return (CartItem) query.uniqueResult();
	    }
	    
	    

}
