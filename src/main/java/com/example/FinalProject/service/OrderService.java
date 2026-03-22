package com.example.FinalProject.service;

import com.example.FinalProject.entity.Order;
import com.example.FinalProject.repository.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Page<Order> getAllOrdersPageable(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    public Page<Order> findOrderByName(String name, Pageable pageable) {
        return orderRepository.findByProduct_NameContainingIgnoreCase(name, pageable);
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Page<Order> findByLowQuantityOrder(int quantity, Pageable pageable) {
        return orderRepository.findByLowQuantityOrder(quantity, pageable);
    }

    public Page<Order> findByAverageQuantityOrder(int quantity1, int quantity2, Pageable pageable) {
        return orderRepository.findByAverageQuantityOrder(quantity1, quantity2, pageable);
    }

    public Page<Order> findByHighQuantityOrder(int quantity, Pageable pageable) {
        return orderRepository.findByHighQuantityOrder(quantity, pageable);
    }
}
