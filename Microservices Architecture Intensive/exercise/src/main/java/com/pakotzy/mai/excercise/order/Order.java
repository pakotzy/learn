package com.pakotzy.mai.excercise.order;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Document
@Data
@AllArgsConstructor
public class Order {
    @Id
    private String id;
    private String productId;
    private Long quantity;
}
