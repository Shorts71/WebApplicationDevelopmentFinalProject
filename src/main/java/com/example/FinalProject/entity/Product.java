package com.example.FinalProject.entity;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    private String description;

    @ManyToOne
    private Brand brand;

    @OneToOne(cascade = CascadeType.ALL)
    private Inventory inventory;

    public Product() {
        this.inventory = new Inventory();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public Brand getBrand() {
        return brand;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}