package com.example.FinalProject.controller;

import com.example.FinalProject.entity.Brand;
import com.example.FinalProject.repository.BrandRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BrandController {

    private final BrandRepository brandRepository;

    public BrandController(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @GetMapping("/brands")
    public String brands(Model model) {
        model.addAttribute("brands", brandRepository.findAll());
        return "brands";
    }

    @GetMapping("/brands/new")
    public String newBrand(Model model) {
        model.addAttribute("brand", new Brand());
        return "brand-form";
    }

    @PostMapping("/brands/save")
    public String saveBrand(@ModelAttribute Brand brand) {
        brandRepository.save(brand);
        return "redirect:/brands";
    }
}