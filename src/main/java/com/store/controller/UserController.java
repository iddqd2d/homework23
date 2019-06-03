package com.store.controller;

import com.store.model.User;
import com.store.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private UserService service;

    @GetMapping("/registration")
    public ModelAndView addUser() {
        return new ModelAndView("registration", "user", new User());
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/registration")
    public String addUser(User user) {
        service.createUser(user);
        return "redirect:/home";
    }
}
