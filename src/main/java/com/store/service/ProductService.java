package com.store.service;

import com.store.model.Product;

import java.util.List;

public interface ProductService {

    void addProduct(Product product);

    void changeProduct(Product product);

    void deleteProductById(Integer id);

    Product getProductById(Integer id);

    List<Product> getAllProducts();
}
