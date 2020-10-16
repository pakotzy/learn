package com.pakotzy.mai.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product", url = "localhost:8081")
public interface ProductRepository {
    @GetMapping("/product/{productId}")
    Object existsById(@PathVariable String productId);
}
