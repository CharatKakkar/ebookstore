package com.ebookstore.dao;

import java.util.List;

import com.ebookstore.model.Product;

/**
 * Created by Le on 1/6/2016.
 */
public interface ProductDao {

    List<Product> getProductList();

    Product getProductById(int id);

    
}
