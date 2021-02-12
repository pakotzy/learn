package com.pakotzy.mai.product;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ProductApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ProductApplication.class).web(WebApplicationType.SERVLET).run(args);
    }

}
