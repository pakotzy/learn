package com.pakotzy.mai.order;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrderApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(OrderApplication.class).web(WebApplicationType.SERVLET).run(args);
	}

}
