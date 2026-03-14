package com.example.FinalProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrdersController {

    @GetMapping("/orders")
    public String orders() {
        return "orders";
    }

    @GetMapping("/orders/new")
    public String newOrder() {
        return "order-form";
    }
}
