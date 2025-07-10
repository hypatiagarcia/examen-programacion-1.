package com.example.springbootapp.controller;

import com.example.springbootapp.model.User;
import com.example.springbootapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String listAll(Model model) {
        System.out.println("DEBUG: Entrando al método listAll de UserController");
        try {
            List<User> users = userService.findAll();
            System.out.println("DEBUG: Usuarios encontrados: " + users.size());
            model.addAttribute("users", users);
            System.out.println("DEBUG: Retornando vista user/list");
            return "user/list";
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
            return "error";
        }
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("user", new User());
        return "user/form";
    }

    @PostMapping
    public String saveUser(@Validated @ModelAttribute User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.findById(id).orElse(new User()));
        return "user/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }
}

