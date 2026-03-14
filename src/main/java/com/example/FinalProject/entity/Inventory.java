package com.example.FinalProject.entity;

import jakarta.persistence.*;
@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryId;

    private Integer quantity;
    private String location;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
}