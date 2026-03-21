package com.example.FinalProject.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 50, message = "Name must be longer than 3 characters and shorter than 50 characters.")
    @NotBlank(message = "Product name is required.")
    @Column(nullable = false, unique = true)
    private String name;

    @NotNull(message = "Price is required.")
    @Min(value = 1, message = "Price must be greater than 0.")
    @Max(value = 999999999, message = "Price must be less than 1 billion.")
    private Double price;

    @NotNull(message = "Description is required.")
    @Size(min = 0, max = 400, message = "Description is too long.")
    private String description;

    @Min(value = 1, message = "Stock count must be greater than 0.")
    @Max(value = 999999999, message = "Stock count must be less than 1 billion.")
    @Column(name = "stock_count")
    private int stockCount;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @OneToOne(cascade = CascadeType.ALL)
    private Inventory inventory;

}