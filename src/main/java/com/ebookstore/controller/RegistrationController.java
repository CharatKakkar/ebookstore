package com.ebookstore.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	public String registrationData(@Valid @ModelAttribute("customer") Customer customer, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "registration";
		}

		String enteredUsername = customer.getUserName();
		List<Customer> listOfCustomer = customerService.getAllCustomers();
		for (Customer myCustomer : listOfCustomer) {
			if (enteredUsername.equalsIgnoreCase(myCustomer.getUserName())) {
				String msg = ("Username " + enteredUsername + " already exists");
				model.addAttribute("error", msg);
				return "registration";
			}
		}
		customerService.addCustomer(customer);
		String msg = ("Registration successful Please login with " + enteredUsername);
		model.addAttribute("error", msg);
		return "login";
	}
}
