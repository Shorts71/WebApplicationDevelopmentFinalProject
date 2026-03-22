package com.example.FinalProject.repository;

import com.example.FinalProject.entity.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    // Server-side filtering by brand name
    Page<Brand> findByBrandNameContainingIgnoreCase(String brandName, Pageable pageable);

    @Query("Select b from Brand b WHERE b.brandName = :brandName")
    Optional<Brand> findByBrandName(@Param("brandName") String brandName);

    Optional<Brand> findByBrandNameIgnoreCase(String brandName);
}