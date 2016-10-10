package com.ebookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ebookstore.model.BillingAddress;
import com.ebookstore.model.Customer;
import com.ebookstore.model.ShippingAddress;
import com.ebookstore.service.CustomerService;


@Controller
@RequestMapping("/registration")
public class RegistrationController {
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping("/register")
	public String registration(Model model) {
		Customer customer = new Customer();
		BillingAddress billingAddress = new BillingAddress();
		ShippingAddress shippingAddress = new ShippingAddress();
		customer.setBillingAddress(billingAddress);
		customer.setShippingAddress(shippingAddress);
		model.addAttribute("customer", customer);
		return "registration";
	}

	@RequestMapping(value = "/registrationData", method = RequestMethod.POST)
	public String registrationData(@ModelAttribute("customer") Customer customer) {
		customerService.addCustomer(customer);
		return "login";
	}
	
	
	
}
