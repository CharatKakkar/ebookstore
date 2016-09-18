package com.ebookstore.dao;

import java.util.List;

import com.ebookstore.model.Product;


public interface ProductDao {

    List<Product> getProductList();

    Product getProductById(int id);
    
    void addProduct(Product product);
    
    void editProduct(Product product);
    
    void deleteProduct(int id);

    
}
