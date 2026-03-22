package com.example.FinalProject.service;

import com.example.FinalProject.entity.Brand;
import com.example.FinalProject.repository.BrandRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {
    private BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    public Page<Brand> getAllBrandsPageable(Pageable pageable) {
        return brandRepository.findAll(pageable);
    }

    public void addBrand(Brand brand) {
        brandRepository.save(brand);
    }

    public Page<Brand> findBrandByName(String brandName, Pageable pageable) {
        return brandRepository.findByBrandNameContainingIgnoreCase(brandName, pageable);
    }

    public Brand getBrandById(Long id) {
        return brandRepository.findById(id).orElse(null);
    }
}
