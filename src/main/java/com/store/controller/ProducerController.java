package com.store.controller;

import com.store.model.Producer;
import com.store.model.Product;
import com.store.service.ProducerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/producer")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProducerController {

    private final ProducerService producerService;

    @GetMapping("/all")
    public ModelAndView producers() {
        return new ModelAndView("producers", "producers", producerService.getAllProducers());
    }

    @GetMapping("/add")
    public ModelAndView addProducer() {
        return new ModelAndView("add-producer", "producer", new Producer());
    }

    @PostMapping("/add")
    public String addProducer(Producer producer) {
        producerService.addProducer(producer);
        return "redirect:/producer/all";
    }

    @GetMapping("/update/{id}")
    public ModelAndView changeProducer(@PathVariable("id") Integer id) {
        return new ModelAndView("change-producer", "producer", producerService.getProducerById(id));
    }

    @GetMapping("/delete/{id}")
    public String deleteProducer(@PathVariable("id") Integer id) {
        producerService.deleteProducerById(id);
        return "redirect:/producer/all";
    }

    @PutMapping("/")
    public String changeProject(Producer producer) {
        producerService.changeProducer(producer);
        return "redirect:/producer/all";
    }
}
