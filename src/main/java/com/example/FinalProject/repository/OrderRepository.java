package com.example.FinalProject.repository;

import com.example.FinalProject.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

    // Server-side filtering by product name or order date (example)
    Page<Order> findByItems_Product_NameContainingIgnoreCase(String productName, Pageable pageable);
}