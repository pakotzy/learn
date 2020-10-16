package com.pakotzy.mai.excercise.product;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "product")
public interface ProductRepository extends MongoRepository<Product, String> {
    
}
