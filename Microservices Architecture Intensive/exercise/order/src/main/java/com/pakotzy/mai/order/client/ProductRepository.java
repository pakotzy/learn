package com.pakotzy.mai.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("product")
public interface ProductRepository {
    @GetMapping("/products/{productId}")
    void existsById(@PathVariable String productId);
}
