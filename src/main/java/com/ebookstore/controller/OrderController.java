/**
 * 
 */
package com.ebookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ebookstore.model.Cart;
import com.ebookstore.model.Customer;
import com.ebookstore.model.Orders;
import com.ebookstore.service.CartService;
import com.ebookstore.service.OrderService;

/**
 * @author Charat Kakkar
 *
 */

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	CartService cartService;
	
	@Autowired
	OrderService orderService;
		
	@RequestMapping("/{cartId}")
	private String customerDetails(@PathVariable int cartId, Model model){
		Orders myOrder = new Orders();
		Cart myCart = cartService.getCartById(cartId);	
		myOrder.setCart(myCart);
		myOrder.setCustomer(myCart.getCustomer());
		myOrder.setBillingAddress(myCart.getCustomer().getBillingAddress());
		myOrder.setShippingAddress(myCart.getCustomer().getShippingAddress());
		orderService.saveOrder(myOrder);
		model.addAttribute("myOrder", myOrder);
		return "customerDetails";
	}
	
//	@RequestMapping(value="/orderConfirmation" , method= RequestMethod.POST)
//	private String orderConfirmation (@ModelAttribute ("order") Orders order, Model model){
//		orderService.saveOrder(order);
//		model.addAttribute("order", order);
//		return "orderConfirmation";	
//		
//	}
//	
	

}
