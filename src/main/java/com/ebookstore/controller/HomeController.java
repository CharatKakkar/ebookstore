package com.ebookstore.controller;

import java.nio.file.attribute.UserPrincipal;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ebookstore.model.Customer;
import com.ebookstore.service.CustomerService;

@Controller
public class HomeController {
	
	@Autowired
	CustomerService customerService;

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/Login")
    public String login() {
        return "Login";
    }

    @RequestMapping("/registration")
    public String registration() {
        return "registration";
    }

    @RequestMapping("/passwordValidator")
    public String passwordValidator(Model model, Principal principal) {
    	String currentUsername=	principal.getName();
    	Customer currentCustomer = customerService.getCustomerByuserName(currentUsername);
    	model.addAttribute("currentCustomer", currentCustomer);
        return "passwordValidator";
    }
    

    @RequestMapping("/about")
    public String about() {
        return "about";
    }
    
   
	
	
}
