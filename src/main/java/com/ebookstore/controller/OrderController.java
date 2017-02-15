/**
 * 
 */
package com.ebookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ebookstore.model.BillingAddress;
import com.ebookstore.model.Cart;
import com.ebookstore.model.Customer;
import com.ebookstore.model.Orders;
import com.ebookstore.service.CartService;
import com.ebookstore.service.CustomerService;
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

	@Autowired
	CustomerService customerService;

	@RequestMapping("/{cartId}")
	private String customerDetails(@PathVariable int cartId, Model model) {
		Orders myOrder = new Orders();
		Cart myCart = cartService.getCartById(cartId);
		myOrder.setCart(myCart);
		myOrder.setCustomer(myCart.getCustomer());
		myOrder.setBillingAddress(myCart.getCustomer().getBillingAddress());
		myOrder.setShippingAddress(myCart.getCustomer().getShippingAddress());
		//orderService.saveOrder(myOrder);
		System.out.println("Customer id that is being passed" + myCart.getCustomer().getCustomerId());
		//return "redirect:/orderCheckout?customerId=" + myCart.getCustomer().getCustomerId();
		return "redirect:/orderCheckout";

	}

	@RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
	private String updateCustomerInfo(@ModelAttribute("customer") Customer customer, Model model) {
		//Customer myCustomer = customerService.getCustomerByuserName(customer.getUserName());
		//myCustomer.getBillingAddress().setState(customer.getBillingAddress().getState());
		
//		/myCustomer.setBillingAddress(customer.getBillingAddress().getState());
		//myCustomer.setBillingAddress(myCustomer.getBillingAddress().setState(customer.getBillingAddress().getState()));
		//myCustomer.setConfirmPassword(myCustomer.getPassword());
		//System.out.println("customer state is  "  + myCustomer.getBillingAddress().getState());
		
//		customerService.modifyCustomer(myCustomer);
//		Customer updatedCustomer= customerService.getCustomerByuserName(myCustomer.getUserName());
		Customer updatedCustomer=customerService.updateCustomerInfo(customer);
		model.addAttribute("customer", updatedCustomer);
		return "redirect:/orderCheckout?customerId=" + updatedCustomer.getCustomerId();

	}

	// @RequestMapping(value="/orderConfirmation" , method= RequestMethod.POST)
	// private String orderConfirmation (@ModelAttribute ("order") Orders order,
	// Model model){
	// orderService.saveOrder(order);
	// model.addAttribute("order", order);
	// return "orderConfirmation";
	//
	// }
	//
	
	private void saveOrder(Orders order){
		//orderService.saveOrder(order);
		System.out.println("Order id is " + order.getOrderId());
		return ;
		
	}

}
