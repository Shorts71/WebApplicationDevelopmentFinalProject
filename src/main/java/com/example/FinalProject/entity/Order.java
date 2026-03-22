package com.example.FinalProject.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Quantity is required.")
    @Min(value = 1)
    @Max(value = 999999999)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @NotNull(message = "Product is required.")
    private Product product;

    @Column(name = "total_amount")
    private double totalAmount;

    @Column(name = "order_date")
    private LocalDateTime orderDate;
}