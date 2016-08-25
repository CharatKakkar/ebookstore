package com.ebookstore.service;

import java.util.List;

import com.ebookstore.model.Product;


public interface ProductService {

    List<Product> getProductList();

    Product getProductById(int id);
}
