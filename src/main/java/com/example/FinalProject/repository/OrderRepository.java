package com.example.FinalProject.repository;

import com.example.FinalProject.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    // Server-side filtering by product name or order date (example)
    Page<Order> findByProduct_NameContainingIgnoreCase(String name, Pageable pageable);

    @Query("SELECT o from Order o WHERE o.quantity < ?1 ORDER BY o.quantity DESC")
    Page<Order> findByLowQuantityOrder(int quantity, Pageable pageable);

    @Query("SELECT o from Order o WHERE o.quantity < ?1 AND o.quantity > ?2 ORDER BY o.quantity DESC")
    Page<Order> findByAverageQuantityOrder(int quantity1, int quantity2, Pageable pageable);

    @Query("SELECT o from Order o WHERE o.quantity > ?1 ORDER BY o.quantity DESC")
    Page<Order> findByHighQuantityOrder(int quantity, Pageable pageable);


}