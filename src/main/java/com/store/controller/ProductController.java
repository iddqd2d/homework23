package com.store.controller;

import com.store.model.Product;
import com.store.model.User;
import com.store.service.ProducerService;
import com.store.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;


@Controller
@RequestMapping("/product")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductController {

    private final ProductService productService;
    private final ProducerService producerService;

    @GetMapping("/all")
    public ModelAndView products() {
        return new ModelAndView("products", "products", productService.getAllProducts());
    }

    @GetMapping("/add")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("producers", producerService.getAllProducers());
        return "add-product";
    }

    @PostMapping("/add")
    public String addProduct(Product product) {
        productService.addProduct(product);
        return "redirect:/product/all";
    }

    @GetMapping("/update/{id}")
    public String changeProduct(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        model.addAttribute("producers", producerService.getAllProducers());
        return "change-product";
    }

    @GetMapping("/delete-product/{id}")
    public String deleteProduct(@PathVariable("id") Integer id) {
        productService.deleteProductById(id);
        return "redirect:/product/all";
    }

    @PutMapping("/products")
    public String changeProject(Product product) {
        productService.changeProduct(product);
        return "redirect:/product/all";
    }
}
