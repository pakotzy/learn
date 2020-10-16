package com.pakotzy.mai.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product", url = "product:8080")
public interface ProductRepository {
    @GetMapping("/products/{productId}")
    void existsById(@PathVariable String productId);
}
