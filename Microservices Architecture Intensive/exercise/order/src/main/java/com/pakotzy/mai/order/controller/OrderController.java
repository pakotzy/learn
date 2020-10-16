package com.pakotzy.mai.order.controller;

import com.pakotzy.mai.order.client.ProductRepository;
import com.pakotzy.mai.order.dao.Order;
import com.pakotzy.mai.order.repository.OrderRepository;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import feign.FeignException;

@RestController
public class OrderController {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public OrderController(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @PostMapping("products/{productId}/orders")
    public Order createOrderByProductId(@PathVariable String productId) {
        try {
            productRepository.existsById(productId);
        } catch (FeignException.NotFound ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Product with given Id: " + productId);
        }

        return orderRepository.save(new Order(null, productId, 1L));
    }
}
