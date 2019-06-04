package com.store.controller;

import com.store.model.Producer;
import com.store.model.Product;
import com.store.service.ProducerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProducerController {

    private final ProducerService producerService;

    @GetMapping("/producers")
    public ModelAndView producers() {
        return new ModelAndView("producers", "producers", this.producerService.getAllProducers());
    }

    @GetMapping("/add-producer")
    public ModelAndView addProducer() {
        return new ModelAndView("add-producer", "producer", new Producer());
    }

    @PostMapping("/add-producer")
    public String addProducer(Producer producer) {
        producerService.addProducer(producer);
        return "redirect:/producers";
    }

    @GetMapping("/update-producer/{id}")
    public ModelAndView changeProducer(@PathVariable("id") Integer id) {
        return new ModelAndView("change-producer", "producer", producerService.getProducerById(id));
    }

    @GetMapping("/delete-producer/{id}")
    public String deleteProducer(@PathVariable("id") Integer id) {
        producerService.deleteProducerById(id);
        return "redirect:/producers";
    }

    @PutMapping("/producers")
    public String changeProject(Producer producer) {
        producerService.changeProducer(producer);
        return "redirect:/producers";
    }
}
