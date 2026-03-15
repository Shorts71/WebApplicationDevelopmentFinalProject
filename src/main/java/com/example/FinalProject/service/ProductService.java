package com.example.FinalProject.service;

import com.example.FinalProject.entity.Product;
import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product saveProduct(Product product);

}