package com.ebookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ebookstore.model.Product;
import com.ebookstore.service.ProductService;



@Controller
public class HomeController {
	
	@Autowired
	ProductService productService;

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    

    @RequestMapping("/about")
    public String about() {
        return "about";
    }
    
    @RequestMapping("/admin")
    public String admin(){
    	return "adminPage";
    }
    
    @RequestMapping("/admin/productInventory")
    public String productInventory(Model model){
    	List<Product> products = productService.getProductList();
    	model.addAttribute("products",products);
    	return "productInventoryAdmin";
    }
    
	@RequestMapping("/admin/product/addProduct")
	public String addProductAdmin(Model model) {
		Product product = new Product();
		product.setProductStatus("2");
		product.setUnitInStock(5);
		product.setProductPublisher("Sydney");
		model.addAttribute("product", product);
		return "addProduct";
	}

	/*
    @RequestMapping(value="/admin/productInventory/addProduct" , method=RequestMethod.POST)
    public String addProductRedirect(@ModelAttribute("product") Product product){
    	productService.addProduct(product);   
    	return "adminPage";
    	//return "redirect:/admin/productInventory";
    	
    }
    
    */
	
	  @RequestMapping(value = "/admin/productInventory/addProduct", method = RequestMethod.POST)
	    public String addProductPost(@ModelAttribute("product") Product product) {
		  productService.addProduct(product);
		  return "redirect:/admin/productInventory";
	    }

    
}
