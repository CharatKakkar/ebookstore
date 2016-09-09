package com.ebookstore.controller;

import com.ebookstore.model.Product;
import com.ebookstore.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/productList/all")
    public String getProducts(Model model) {
        List<Product> products = productService.getProductList();
        model.addAttribute("products", products);

        return "productList";
    }

    @RequestMapping("/viewProduct/{productId}")
    public String viewProduct(@PathVariable int productId, Model model) throws IOException {
        Product product=productService.getProductById(productId);
        model.addAttribute("product", product);

        return "viewProduct";
    }

    @RequestMapping("/productList")
    public String getProductByCategory( Model model) {
        List<Product> products = productService.getProductList();
        model.addAttribute("products", products);
      
        return "productList";
    }
    
    @RequestMapping("/productInventory")
    public String getAllProductsAdmin(Model model){    	
    	List<Product> products = productService.getProductList();
    	model.addAttribute("products",products);    	
    	return "productInventory";
    }
    
 
}
