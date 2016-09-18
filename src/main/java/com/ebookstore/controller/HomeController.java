package com.ebookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	


    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/Login")
    public String login() {
        return "Login";
    }

    

    @RequestMapping("/about")
    public String about() {
        return "about";
    }
    
   
	
	
}
