package com.example.FinalProject.controller;

import com.example.FinalProject.entity.Brand;
import com.example.FinalProject.entity.Product;
import com.example.FinalProject.repository.BrandRepository;
import com.example.FinalProject.repository.ProductRepository;
import com.example.FinalProject.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;

    public ProductController(ProductService productService, ProductRepository productRepository, BrandRepository brandRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
        this.brandRepository = brandRepository;
    }

    // Server-side paginated, sortable, filterable list
    @GetMapping
    public String listProducts(
            @RequestParam(name = "brand", required = false, defaultValue = "") String brand,
            @RequestParam(name = "name", required = false, defaultValue = "") String name,
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "size", required = false, defaultValue = "10") int size,
            @RequestParam(name = "sortField", required = false, defaultValue = "id") String sortField,
            @RequestParam(name = "sortDir", required = false, defaultValue = "ASC") String sortDir,
            @RequestParam(name = "filterType", required = false, defaultValue = "all") String filterType,
            Model model) {

        Sort.Direction sortedDirection = sortDir.equalsIgnoreCase("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(sortedDirection, sortField);

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Product> productPage;

        if (!brand.isEmpty() || !name.isEmpty()) {
            productPage = productService.findProductByName(brand, name, pageable);
        } else {
            productPage = switch (filterType) {
                case "low" -> productService.findByLowStock(10, pageable);
                case "average" -> productService.findByAverageStock(10, 50, pageable);
                case "high" -> productService.findByHighStock(50, pageable);
                default -> productService.getAllProductsPageable(pageable);
            };
        }

        model.addAttribute("productPage", productPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", productPage.getTotalPages());
        model.addAttribute("totalItems", productPage.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("size", size);
        model.addAttribute("nameFilter", name);
        model.addAttribute("brandFilter", brand);
        model.addAttribute("filterType", filterType);

        return "products";
    }

    @GetMapping("/new")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("brands", brandRepository.findAll());
        return "product-form";
    }

    @PostMapping("/save")
    public String saveProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "product-form";
        }
        product.setBrand(brandRepository.findById(product.getBrand().getId()).orElse(null));

        productRepository.save(product);
        return "redirect:/products";
    }
}