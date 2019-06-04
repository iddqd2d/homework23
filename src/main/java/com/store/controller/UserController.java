package com.store.controller;

import com.store.model.User;
import com.store.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final UserService service;

    @GetMapping("/users")
    public ModelAndView users() {
        return new ModelAndView("users", "users", service.getAllUsers());
    }

    @GetMapping("/add-user")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "add-user";
    }

    @PostMapping("/add-user")
    public String addUser(User user) {
        service.createUser(user);
        return "redirect:/users";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
