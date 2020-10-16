package com.pakotzy.mai.product.repository;

import com.pakotzy.mai.product.dao.Product;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "product")
public interface ProductRepository extends MongoRepository<Product, String> {
    
}
