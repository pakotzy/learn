package com.pakotzy.mai.order.repository;

import com.pakotzy.mai.order.dao.Order;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface OrderRepository extends MongoRepository<Order, String> {
    
}
