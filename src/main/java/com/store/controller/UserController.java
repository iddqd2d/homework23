package com.store.controller;

import com.store.model.User;
import com.store.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final UserService service;

    @GetMapping("/all")
    public ModelAndView users() {
        return new ModelAndView("users", "users", service.getAllUsers());
    }

    @GetMapping("/add")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "add-user";
    }

    @PostMapping("/add")
    public String addUser(User user) {
        service.createUser(user);
        return "redirect:/user/all";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @GetMapping("/update/{id}")
    public ModelAndView changeUser(@PathVariable("id") Integer id) {
        return new ModelAndView("change-user", "user", service.getUserById(id));
    }

    @GetMapping("/delete/{id}")
    public String deleteProducer(@PathVariable("id") Integer id) {
        service.deleteUserById(id);
        return "redirect:/user/all";
    }

    @PutMapping("/all")
    public String changeUser(User user) {
        service.changeUser(user);
        return "redirect:/user/all";
    }
}
