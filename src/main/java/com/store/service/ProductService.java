package com.store.service;

import com.store.model.Product;

public interface ProductService {

    void addProduct(Product product);

    void changeProduct(Product product);

    void deleteProductById(Integer id);

    Product getProductById(Integer id);

    Iterable<Product> getAllProducts();

    void deleteAllProducts();

    Integer getMaxId();
}
