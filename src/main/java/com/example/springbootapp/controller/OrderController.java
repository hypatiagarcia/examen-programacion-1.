package com.example.springbootapp.controller;

import com.example.springbootapp.model.Order;
import com.example.springbootapp.model.Product;
import com.example.springbootapp.model.User;
import com.example.springbootapp.service.OrderService;
import com.example.springbootapp.service.ProductService;
import com.example.springbootapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final UserService userService;
    private final ProductService productService;

    @Autowired
    public OrderController(OrderService orderService, UserService userService, ProductService productService) {
        this.orderService = orderService;
        this.userService = userService;
        this.productService = productService;
    }

    @GetMapping
    public String listAll(Model model) {
        model.addAttribute("orders", orderService.findAll());
        return "order/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("order", new Order());
        model.addAttribute("users", userService.findAll());
        model.addAttribute("products", productService.findAll());
        return "order/form";
    }

    @PostMapping
    public String saveOrder(@Validated @ModelAttribute Order order) {
        orderService.save(order);
        return "redirect:/orders";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("order", orderService.findById(id).orElse(new Order()));
        model.addAttribute("users", userService.findAll());
        model.addAttribute("products", productService.findAll());
        return "order/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id) {
        orderService.deleteById(id);
        return "redirect:/orders";
    }
}

