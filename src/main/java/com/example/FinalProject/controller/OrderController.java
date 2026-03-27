package com.example.FinalProject.controller;

import com.example.FinalProject.entity.Order;
import com.example.FinalProject.repository.OrderRepository;
import com.example.FinalProject.service.OrderService;
import com.example.FinalProject.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final OrderRepository orderRepository;

    private final ProductService productService;

    public OrderController(OrderService orderService, OrderRepository orderRepository, ProductService productService) {
        this.orderService = orderService;
        this.orderRepository = orderRepository;
        this.productService = productService;
    }

    @GetMapping
    public String listOrders(
            @RequestParam(name = "order", required = false, defaultValue = "") String order,
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "size", required = false, defaultValue = "10") int size,
            @RequestParam(name = "sortField", required = false, defaultValue = "id") String sortField,
            @RequestParam(name = "sortDir", required = false, defaultValue = "ASC") String sortDir,
            @RequestParam(name = "filterType", required = false, defaultValue = "all") String filterType,
            Model model) {

        Sort.Direction sortedDirection = sortDir.equalsIgnoreCase("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(sortedDirection, sortField);

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Order> orderPage;

        if (!order.isEmpty()) {
            orderPage = orderRepository.findByProduct_NameContainingIgnoreCase(order, pageable);
        } else {
            orderPage = switch (filterType) {
                case "low" -> orderService.findByLowQuantityOrder(10, pageable);
                case "average" -> orderService.findByAverageQuantityOrder(10, 50, pageable);
                case "high" -> orderService.findByHighQuantityOrder(50, pageable);
                default -> orderService.getAllOrdersPageable(pageable);
            };
        }

        model.addAttribute("orderPage", orderPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", orderPage.getTotalPages());
        model.addAttribute("totalItems", orderPage.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("size", size);
        model.addAttribute("orderFilter", order);
        model.addAttribute("filterType", filterType);

        return "orders";
    }

    @GetMapping("/new")
    public String newOrder(Model model) {
        model.addAttribute("order", new Order());
        model.addAttribute("products", productService.getAllProducts());
        return "order-form";
    }

    @PostMapping("/save")
    public String saveOrder(@Valid @ModelAttribute("order") Order order, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("products", productService.getAllProducts());
            return "order-form";
        }

        Long productId = order.getProduct().getId();
        order.setProduct(productService.getProductById(productId));
        order.setQuantity(order.getQuantity());
        order.setTotalAmount(order.getQuantity() * order.getProduct().getPrice());
        order.setOrderDate(LocalDateTime.now());

        orderService.addOrder(order);

        return "redirect:/orders";
    }
}