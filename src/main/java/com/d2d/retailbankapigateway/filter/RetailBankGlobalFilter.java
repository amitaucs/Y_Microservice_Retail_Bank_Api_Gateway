package com.d2d.retailbankapigateway.filter;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class RetailBankGlobalFilter  implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("***** Inside the global filter *******");
        var requestWithHeader = exchange.getRequest().mutate()
                .header("retailBank", "Retail Bank Application")
                .build();
        return chain.filter(exchange.mutate().request(requestWithHeader).build());
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
