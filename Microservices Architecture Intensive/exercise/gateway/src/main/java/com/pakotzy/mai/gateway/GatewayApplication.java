package com.pakotzy.mai.gateway;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixObservableCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.ReactiveHystrixCircuitBreakerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("order", r -> r.path("/products/*/orders/**")
                        .filters(f -> f.hystrix(config ->
                                config.setName("order-cb").setFallbackUri("forward:/fallback")))
                        .uri("lb://order"))
                .route("product", r -> r.path("/products/**")
                        .filters(f -> f.hystrix(config -> config.setFallbackUri("forward:/fallback")))
                        .uri("lb://product"))
                .build();
    }

    @Bean
    public Customizer<ReactiveHystrixCircuitBreakerFactory> defaultCircuitBreakerCustomizer() {
        return factory -> factory.configureDefault(id -> HystrixObservableCommand.Setter
                .withGroupKey(HystrixCommandGroupKey.Factory.asKey(id))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withExecutionTimeoutInMilliseconds(4000)));
    }

    @Bean
    public Customizer<ReactiveHystrixCircuitBreakerFactory> circuitBreakerCustomizer() {
        return factory -> factory.configure(builder -> builder.commandProperties(
                HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(2000)), "order-cb");
    }

    @RequestMapping("/fallback")
    public Mono<String> fallback() {
        return Mono.just("fallback");
    }
}
