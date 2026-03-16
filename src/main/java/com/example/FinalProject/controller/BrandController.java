package com.example.FinalProject.controller;

import com.example.FinalProject.entity.Brand;
import com.example.FinalProject.repository.BrandRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/brands")
public class BrandController {

    private final BrandRepository brandRepository;

    public BrandController(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @GetMapping
    public String listBrands(
            @RequestParam(defaultValue = "") String brand,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "brandName") String sortField,
            @RequestParam(defaultValue = "asc") String sortDir,
            Model model) {

        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Brand> brandPage = brandRepository.findByBrandNameContainingIgnoreCase(brand, pageable);

        model.addAttribute("brandPage", brandPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", brandPage.getTotalPages());
        model.addAttribute("totalItems", brandPage.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("brandFilter", brand);

        return "brands";
    }
}