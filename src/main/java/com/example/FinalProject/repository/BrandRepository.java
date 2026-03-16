package com.example.FinalProject.repository;

import com.example.FinalProject.entity.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    // Server-side filtering by brand name
    Page<Brand> findByBrandNameContainingIgnoreCase(String brandName, Pageable pageable);
}