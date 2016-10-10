package com.ebookstore.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ebookstore.dao.CartDao;
import com.ebookstore.dao.ProductDao;
import com.ebookstore.model.Cart;
import com.ebookstore.model.CartItem;
import com.ebookstore.model.Product;

@Controller
@RequestMapping("/rest/cart")
public class CartController {
	
	@Autowired
	private ProductDao productDao;

	@Autowired
	private CartDao cartDao;
	
	@RequestMapping(value="{cartId}", method=RequestMethod.GET) 
	public @ResponseBody Cart getCart(@PathVariable(value="cartId") int cartId){		
		return cartDao.getCartById(cartId);
	}
	
	@RequestMapping(value="{cardId}" , method=RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public Cart updateCart(@PathVariable(value="cartId") int cartId, @RequestBody Cart cart){
		return cartDao.updateCart(cartId, cart);
	}
	
	@RequestMapping(value="{cartId}" , method=RequestMethod.DELETE)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void deleteCart(@PathVariable (value="{cartId}") int cartId){
		cartDao.deleteCart(cartId);		
	}

	@RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
	public void addItem(@PathVariable(value = "productId") int productId, HttpServletRequest session) {
		CartItem item = null;


	}

	@RequestMapping(value = "/delete/{productId}", method = RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void deleteItem(@PathVariable(value = "{productId})") int productId, HttpServletRequest session) {

		
	}
	
//Add exception handlers
}
