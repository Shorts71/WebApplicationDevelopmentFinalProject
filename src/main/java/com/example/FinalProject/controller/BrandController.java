package com.example.FinalProject.controller;

import com.example.FinalProject.entity.Brand;
import com.example.FinalProject.repository.BrandRepository;
import com.example.FinalProject.service.BrandService;
import jakarta.validation.Valid;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/brands")
public class BrandController {

    private final BrandService brandService;
    private final BrandRepository brandRepository;

    public BrandController(BrandService brandService, BrandRepository brandRepository) {
        this.brandService = brandService;
        this.brandRepository = brandRepository;
    }

    @GetMapping
    public String listBrands(
            @RequestParam(name = "brand", required = false, defaultValue = "") String brand,
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "size", required = false, defaultValue = "10") int size,
            @RequestParam(name = "sortField", required = false, defaultValue = "id") String sortField,
            @RequestParam(name = "sortDir", required = false, defaultValue = "ASC") String sortDir,
            Model model) {

        Sort.Direction sortedDirection = sortDir.equalsIgnoreCase("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(sortedDirection, sortField);

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Brand> brandPage;

        if (!brand.isEmpty()) {
            brandPage = brandService.findBrandByName(brand, pageable);
        } else {
            brandPage = brandRepository.findAll(pageable);
        }

        model.addAttribute("brandPage", brandPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", brandPage.getTotalPages());
        model.addAttribute("totalItems", brandPage.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("size", size);
        model.addAttribute("brandFilter", brand);

        return "brands";
    }

    @GetMapping("/new")
    public String newBrand(Model model) {
        model.addAttribute("brand", new Brand());
        return "brand-form";
    }

    @PostMapping("/save")
    public String saveBrand(@Valid @ModelAttribute("brand") Brand brand, BindingResult result, Model model) {
        if (brandRepository.findByBrandName(brand.getBrandName()).isPresent()) {
            return "brand-form";
        }

        if (result.hasErrors()) {
            return "brand-form";
        }

        brandRepository.save(brand);
        return "redirect:/brands";

    }
}