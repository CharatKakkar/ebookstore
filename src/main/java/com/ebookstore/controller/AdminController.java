package com.ebookstore.controller;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ebookstore.model.Product;
import com.ebookstore.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	Path path, path2;
	
	@Autowired
	Helper helper;
	
	@Autowired
	ProductService productService;
	
	@RequestMapping("/adminPage")
	public String admin() {
		return "adminPage";
	}

	@RequestMapping("/productInventory")
	public String productInventory(Model model) {
		List<Product> products = productService.getProductList();
		model.addAttribute("products", products);
		return "productInventoryAdmin";
	}

	@RequestMapping("/productInventory/addProduct")
	public String addProductAdmin(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "addProduct";
	}

	@RequestMapping("/productInventory/editProduct/{productId}")
	public String editProduct(@PathVariable int productId, Model model) throws IOException {
		Product product = productService.getProductById(productId);
		model.addAttribute("product", product);
		return "editProduct";
	}

	//use of @ Valid annotation and @ModelAttribute annotation is new 
	@RequestMapping(value = "/productInventory/addProduct", method = RequestMethod.POST)
	public String addProductPost(@ModelAttribute("product") Product product) {
		productService.addProduct(product);
		//helper = new Helper();
		helper.saveNewImage(product.getProductImage(), product.getProductId());
		return "redirect:/admin/productInventory";
	}

	@RequestMapping(value = "productInventory/updateProduct", method = RequestMethod.POST)
	public String updateProduct( @ModelAttribute("product") Product product ) {	
		productService.editProduct(product);
		//helper = new Helper();
		helper.saveNewImage(product.getProductImage(), product.getProductId());
		return "redirect:/admin/productInventory";
	}

	@RequestMapping(value = "/productInventory/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable int productId) {
		productService.deleteProduct(productId);
		return "redirect:/admin/productInventory";
	}

}
