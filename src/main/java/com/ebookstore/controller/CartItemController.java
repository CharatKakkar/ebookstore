package com.ebookstore.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cart")
public class CartItemController {
	
	@RequestMapping
	public String get (HttpServletRequest request)
	{
		String cartId = request.getSession(true).getId();
		return "redirect:/cart/"+cartId;
	}

	@RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
	public String showCart(@PathVariable("cartId") String cartId, Model model) {
		model.addAttribute("cartId", cartId);
		return "cart";
	}
}
