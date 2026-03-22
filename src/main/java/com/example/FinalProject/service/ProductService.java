package com.example.FinalProject.service;

import com.example.FinalProject.entity.Product;
import com.example.FinalProject.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Page<Product> getAllProductsPageable(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public Page<Product> findProductByName(String brand, String name, Pageable pageable) {
        return productRepository.findByBrand_BrandNameContainingIgnoreCaseAndNameContainingIgnoreCase(brand, name, pageable);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Page<Product> findByLowStock(int stockCount, Pageable pageable) {
        return productRepository.findByLowStock(stockCount, pageable);
    }

    public Page<Product> findByAverageStock(int lowStockCount, int highStockCount, Pageable pageable) {
        return productRepository.findByAverageStock(lowStockCount, highStockCount, pageable);
    }

    public Page<Product> findByHighStock(int stockCount, Pageable pageable) {
        return productRepository.findByHighStock(stockCount, pageable);
    }
}