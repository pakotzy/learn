package com.pakotzy.mai.excercise.order;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface OrderRepository extends MongoRepository<Order, String> {
    
}
