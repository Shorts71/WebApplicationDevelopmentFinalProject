package com.example.FinalProject.controller;

import com.example.FinalProject.entity.Order;
import com.example.FinalProject.entity.OrderItem;
import com.example.FinalProject.entity.Product;
import com.example.FinalProject.repository.OrderRepository;
import com.example.FinalProject.repository.ProductRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrdersController {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrdersController(OrderRepository orderRepository,
                            ProductRepository productRepository) {

        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("/orders")
    public String orders(Model model) {

        model.addAttribute("orders", orderRepository.findAll());

        return "orders";
    }

    @GetMapping("/orders/new")
    public String newOrder(Model model) {

        model.addAttribute("products", productRepository.findAll());

        return "order-form";
    }

    @PostMapping("/orders/save")
    public String saveOrder(@RequestParam Long productId,
                            @RequestParam int quantity) {

        Product product = productRepository
                .findById(productId)
                .orElse(null);

        if (product != null) {

            Order order = new Order();
            order.setOrderDate(java.time.LocalDateTime.now());
            order.setQuantity(quantity);

            double total = product.getPrice() * quantity;
            order.setTotalAmount(total);

            OrderItem item = new OrderItem();
            item.setOrder(order);
            item.setProduct(product);
            item.setQuantity(quantity);

            order.getItems().add(item);

            orderRepository.save(order);
        }

        return "redirect:/orders";
    }
}