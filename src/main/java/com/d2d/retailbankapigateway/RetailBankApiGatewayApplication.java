package com.d2d.retailbankapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class RetailBankApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(RetailBankApiGatewayApplication.class, args);
    }

}
