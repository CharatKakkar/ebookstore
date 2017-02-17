package com.ebookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ebookstore.model.Customer;
import com.ebookstore.service.CustomerService;

@Controller
@RequestMapping("/cart")
public class CartItemController {
	
	@Autowired
	CustomerService customerService;	
	@RequestMapping
	public String get(@AuthenticationPrincipal User activeUser) {
		Customer customer = customerService.getCustomerByuserName(activeUser.getUsername());
		int cartId = customer.getCart().getCartId();
		return "redirect:/cart/" + cartId;
	}

	@RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
	public String showCart(@PathVariable("cartId") String cartId, Model model) {
		model.addAttribute("cartId", cartId);
		return "cart";
	}
}
