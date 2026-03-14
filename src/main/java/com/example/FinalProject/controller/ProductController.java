package com.example.FinalProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @GetMapping("/products")
    public String products() {
        return "products";
    }

    @GetMapping("/products/new")
    public String newProduct() {
        return "product-form";
    }
}
