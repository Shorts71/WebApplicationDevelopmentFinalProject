package com.example.FinalProject.controller;

import com.example.FinalProject.entity.Brand;
import com.example.FinalProject.entity.Product;
import com.example.FinalProject.repository.BrandRepository;
import com.example.FinalProject.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final BrandRepository brandRepository;

    public ProductController(ProductService productService, BrandRepository brandRepository) {
        this.productService = productService;
        this.brandRepository = brandRepository;
    }

    @GetMapping
    public String getProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @GetMapping("/new")
    public String newProduct(Model model) {

        model.addAttribute("product", new Product());
        model.addAttribute("brands", brandRepository.findAll());

        return "product-form";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Product product) {

        if(product.getBrand() == null || product.getBrand().getId() == null){
            return "redirect:/products/new";
        }

        Brand brand = brandRepository.findById(product.getBrand().getId()).orElse(null);
        product.setBrand(brand);

        productService.saveProduct(product);

        return "redirect:/products";
    }
}