package com.d2d.retailbankapigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfiguration {

    @Bean
    public RouteLocator retailBankRoute(RouteLocatorBuilder builder){
        return builder.routes().build();
    }

    @Bean
    public RouteLocator retailBankCircuitBreaker(RouteLocatorBuilder builder){
        return builder.routes()
                .route(p -> p
                        .path("/retailBank/*")
                        .filters(f-> f.circuitBreaker(config -> config
                                .setName("retailBankCircuitBreaker")
                                .setFallbackUri("forward:/fallback/retailBankFallback")))
                                .uri("lb://retail-bank-account-service"))
                        .build();
    }
}
