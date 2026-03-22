package com.example.FinalProject.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "brands")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 50, message = "Brand name must be longer than 3 characters and shorter than 50 characters.")
    @NotBlank(message = "Brand name is required.")
    @Column(name = "brand_name", nullable = false, unique = true)
    private String brandName;

}