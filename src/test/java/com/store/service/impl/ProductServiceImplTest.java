package com.store.service.impl;

import com.store.model.Product;
import com.store.service.ProducerService;
import com.store.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Objects;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test-application.properties")
public class ProductServiceImplTest {
    @Autowired
    ProductService productService;

    @Autowired
    ProducerService producerService;

    @Before
    public void setUp() throws Exception {
        productService.deleteAllProducts();
    }

    @Test
    public void addProduct() {
        Product product = new Product()
                .setName("test")
                .setCost(new BigDecimal(100))
                .setProducer(producerService.getProducerById(producerService.getMaxId()));
        productService.addProduct(product);
        assertEquals("test", productService.getProductById(productService.getMaxId()).getName());
    }

    @Test
    public void changeProduct() {
        Product product = new Product()
                .setName("test")
                .setCost(new BigDecimal(100))
                .setProducer(producerService.getProducerById(producerService.getMaxId()));
        productService.addProduct(product);
        product.setName("test1");
        productService.changeProduct(product);
        assertEquals("test1", productService.getProductById(productService.getMaxId()).getName());
    }

    @Test
    public void deleteProductById() {
        Product product = new Product()
                .setName("test")
                .setCost(new BigDecimal(100))
                .setProducer(producerService.getProducerById(producerService.getMaxId()));
        productService.addProduct(product);
        productService.deleteProductById(productService.getMaxId());
        assertFalse(Objects.nonNull(productService.getMaxId()));
    }

    @Test
    public void getProductById() {
        Product product = new Product()
                .setName("test")
                .setCost(new BigDecimal(100))
                .setProducer(producerService.getProducerById(producerService.getMaxId()));
        productService.addProduct(product);
       assertEquals(productService.getProductById(productService.getMaxId()).getName(),"test");
    }

    @Test
    public void getAllProducts() {
        Product product = new Product()
                .setName("test")
                .setCost(new BigDecimal(100))
                .setProducer(producerService.getProducerById(producerService.getMaxId()));
        productService.addProduct(product);
        Iterable<Product> products = productService.getAllProducts();
        assertEquals("test", products.iterator().next().getName());
    }
}
