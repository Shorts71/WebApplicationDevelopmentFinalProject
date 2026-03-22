//package com.example.FinalProject.entity;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.Max;
//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Table(name = "order_item")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class OrderItem {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @NotNull(message = "Quantity is required.")
//    @Min(value = 1, message = "Quantity must be greater than 0.")
//    @Max(value = 999999999, message = "Quantity must be less than 1 billion.")
//    private int quantity;
//
//    @ManyToOne
//    @JoinColumn(name = "order_id")
//    private Order order;
//
//    @JoinColumn(name = "product_id")
//    @NotNull(message = "Product is required.")
//    private Product product;
//
//}