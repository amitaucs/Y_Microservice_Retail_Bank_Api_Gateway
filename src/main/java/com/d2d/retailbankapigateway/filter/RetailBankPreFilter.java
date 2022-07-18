package com.d2d.retailbankapigateway.filter;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RetailBankPreFilter extends AbstractGatewayFilterFactory<RetailBankPreFilter.Config> {

    public RetailBankPreFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(RetailBankPreFilter.Config config) {

        return((exchange, chain) -> {
            log.info("***** Inside the pre filter *******");
            var requestWithHeader = exchange.getRequest().mutate()
                    .header("retailbankprefilter", "Retail Bank Application Pre Filter")
                    .build();
            return chain.filter(exchange.mutate().request(requestWithHeader).build());
        });
    }

    @Getter
    @Setter
    public static class Config{
        private String name;
    }
}
