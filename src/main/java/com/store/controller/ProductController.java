package com.store.controller;

import com.store.model.Product;
import com.store.model.User;
import com.store.service.ProducerService;
import com.store.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;


@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductController {

    private ProductService productService;
    private ProducerService producerService;

    @GetMapping("/products")
    public ModelAndView products() {
        return new ModelAndView("products", "products", this.productService.getAllProducts());
    }

    @GetMapping("/add-product")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("producers", this.producerService.getAllProducers());
        return "add-product";
    }

    @PostMapping("/add-product")
    public String addProduct(Product product) {
        this.productService.addProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/update-product/{id}")
    public String changeProduct(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("product", this.productService.getProductById(id));
        model.addAttribute("producers", this.producerService.getAllProducers());
        return "change-product";
    }

    @GetMapping("/delete-product/{id}")
    public String deleteProduct(@PathVariable("id") Integer id) {
        this.productService.deleteProductById(id);
        return "redirect:/products";
    }

    @PutMapping("/products")
    public String changeProject(Product product) {
        this.productService.changeProduct(product);
        return "redirect:/products";
    }
}
