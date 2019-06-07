package com.store.service.impl;

import com.store.model.Product;
import com.store.repository.ProductRepository;
import com.store.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    @Override
    public void addProduct(Product product) {
        repository.save(product);
    }

    @Override
    public void changeProduct(Product product) {
        repository.save(product);
    }

    @Override
    public void deleteProductById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Product getProductById(Integer id) {
        return repository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Iterable<Product> getAllProducts() {
       return repository.findAll();
    }

    @Override
    public void deleteAllProducts() {
        repository.deleteAll();
    }

    @Override
    public Integer getMaxId() {
        return repository.getMaxId();
    }
}
