/**
 * 
 */
package com.ebookstore.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ebookstore.model.Customer;
import com.ebookstore.service.CustomerService;

/**
 * @author Charat Kakkar
 *
 */

@Controller
public class ForgotPassword {

	@Autowired
	CustomerService customerService;

	@RequestMapping("/forgotPassword")
	public String forgotPassword(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "forgotPassword";
	}

	@RequestMapping(value = "/validateUsernameEmail", method = RequestMethod.POST)
	public String validateUsernameEmail(@Valid @ModelAttribute("customer") Customer customer, BindingResult result,Model model) {
		if (result.hasErrors()){
			System.out.println("Validation errors");
			return "forgotPassword";
		}
		Customer myCustomer;
		String returnPoint = "";
		if (customerService.isCustomerExists(customer.getUserName())) {
			if (customer.getSecurityPhrase()
					.equals(customerService.getCustomerByuserName(customer.getUserName()).getSecurityPhrase())) {
				myCustomer = customerService.getCustomerByuserName(customer.getUserName());
				myCustomer.setPassword(customer.getPassword());
				myCustomer.setConfirmPassword(customer.getConfirmPassword());
				customerService.modifyCustomer(myCustomer);
				model.addAttribute("msg", "Password for the " + customer.getUserName() + " has been reset successfully");
				returnPoint = "login";
			} else {
				model.addAttribute("error", "Security Phrase that was entered is invalid");
				returnPoint = "forgotPassword";
			}
		} else {
			model.addAttribute("error", "Username " + customer.getUserName() + " doesn't exist");
			returnPoint = "forgotPassword";
		}
		return returnPoint;
	}

}
