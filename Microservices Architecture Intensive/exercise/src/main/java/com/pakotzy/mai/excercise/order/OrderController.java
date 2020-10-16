package com.pakotzy.mai.excercise.order;

import com.pakotzy.mai.excercise.product.ProductRepository;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class OrderController {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public OrderController(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @PostMapping("product/{productId}/order")
    public Order createOrderByProductId(@PathVariable String productId) {
        if (!productRepository.existsById(productId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Product with given Id: " + productId);
        }

        return orderRepository.save(new Order(null, productId, 1L));
    }
}
