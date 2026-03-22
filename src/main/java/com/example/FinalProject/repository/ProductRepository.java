package com.example.FinalProject.repository;

import com.example.FinalProject.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Server-side filtering by brand name and product name
    Page<Product> findByBrand_BrandNameContainingIgnoreCaseAndNameContainingIgnoreCase(
            String brand, String name, Pageable pageable
    );

    //JPQL
    @Query("Select p from Product p WHERE p.brand = :brand")
    Product findByBrand(@Param("brand") String brand);

    Optional<Product> findByName(String name);

    @Query("SELECT p FROM Product p WHERE p.stockCount < ?1 ORDER BY p.stockCount DESC")
    Page<Product> findByLowStock(int stockCount, Pageable pageable);

    @Query("SELECT p FROM Product p WHERE p.stockCount > ?1 AND p.stockCount < ?2 ORDER BY p.stockCount DESC")
    Page<Product> findByAverageStock(int lowStockCount, int highStockCount, Pageable pageable);

    @Query("SELECT p FROM Product p WHERE p.stockCount > ?1 ORDER BY p.stockCount DESC")
    Page<Product> findByHighStock(int stockCount, Pageable pageable);
}