package com.example.FinalProject.repository;

import com.example.FinalProject.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Server-side filtering by brand name and product name
    Page<Product> findByBrand_BrandNameContainingIgnoreCaseAndNameContainingIgnoreCase(
            String brand, String name, Pageable pageable
    );
}