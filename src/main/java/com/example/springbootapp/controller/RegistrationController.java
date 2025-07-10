package com.example.springbootapp.controller;

import com.example.springbootapp.model.User;
import com.example.springbootapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String processRegistration(@Valid @ModelAttribute("user") User user,
                                      BindingResult result,
                                      Model model,
                                      RedirectAttributes redirectAttributes) {
        
        if (result.hasErrors()) {
            return "register";
        }
        
        // Verificar si el usuario ya existe
        if (userService.existsByUsername(user.getUsername())) {
            model.addAttribute("error", "El nombre de usuario ya está en uso");
            return "register";
        }
        
        // Verificar si el email ya existe
        if (userService.existsByEmail(user.getEmail())) {
            model.addAttribute("error", "El email ya está registrado");
            return "register";
        }
        
        try {
            userService.save(user);
            redirectAttributes.addFlashAttribute("success", "Usuario registrado exitosamente");
            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("error", "Error al registrar el usuario: " + e.getMessage());
            return "register";
        }
    }
}
