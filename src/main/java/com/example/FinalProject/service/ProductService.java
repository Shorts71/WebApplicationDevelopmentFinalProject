package com.example.FinalProject.service;

import com.example.FinalProject.entity.Product;
import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);

    List<Product> getAllProducts();

}