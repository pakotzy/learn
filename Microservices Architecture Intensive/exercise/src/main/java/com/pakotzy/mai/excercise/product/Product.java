package com.pakotzy.mai.excercise.product;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Product {
    @Id
    private String id;
    private String name;
    private Long price;
}