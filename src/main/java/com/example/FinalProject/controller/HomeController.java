package com.example.FinalProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

//    @GetMapping("/about")
//    public String about() {
//        return "about";
//    }
//
//    @GetMapping("/products")
//    public String products() {
//        return "products";
//    }
//
//    @GetMapping("/brands")
//    public String brands() {
//        return "brands";
//    }
//
//    @GetMapping("/orders")
//    public String orders() {
//        return "orders";
//    }
//
//    @GetMapping("/products/new")
//    public String newProduct() {
//        return "product-form";
//    }
//
//    @GetMapping("/orders/new")
//    public String newOrder() {
//        return "order-form";
//    }
}