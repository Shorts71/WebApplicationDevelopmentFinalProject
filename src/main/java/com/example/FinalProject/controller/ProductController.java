package com.example.FinalProject.controller;

import com.example.FinalProject.entity.Product;
import com.example.FinalProject.repository.BrandRepository;
import com.example.FinalProject.repository.ProductRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;

    public ProductController(ProductRepository productRepository, BrandRepository brandRepository) {
        this.productRepository = productRepository;
        this.brandRepository = brandRepository;
    }

    // Server-side paginated, sortable, filterable list
    @GetMapping
    public String listProducts(
            @RequestParam(defaultValue = "") String brand,
            @RequestParam(defaultValue = "") String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sortField,
            @RequestParam(defaultValue = "asc") String sortDir,
            Model model) {

        Sort sort = sortDir.equalsIgnoreCase("asc") ?
                Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Product> productPage = productRepository
                .findByBrand_BrandNameContainingIgnoreCaseAndNameContainingIgnoreCase(brand, name, pageable);

        model.addAttribute("productPage", productPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", productPage.getTotalPages());
        model.addAttribute("totalItems", productPage.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("brandFilter", brand);
        model.addAttribute("nameFilter", name);

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

        if (product.getBrand() == null || product.getBrand().getId() == null) {
            return "redirect:/products/new";
        }

        product.setBrand(brandRepository.findById(product.getBrand().getId()).orElse(null));

        productRepository.save(product);
        return "redirect:/products";
    }
}