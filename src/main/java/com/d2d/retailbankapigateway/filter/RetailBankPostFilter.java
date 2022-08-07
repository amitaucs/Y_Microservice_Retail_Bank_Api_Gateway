package com.d2d.retailbankapigateway.filter;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class RetailBankPostFilter extends AbstractGatewayFilterFactory<RetailBankPostFilter.Config> {

   public RetailBankPostFilter(){
       super(Config.class);
   }

    @Override
    public GatewayFilter apply(Config config) {

        log.info("***** Inside the post filter *******");
        return (exchange, chain) -> chain.filter(exchange).then(Mono.fromRunnable(() -> {

            log.info("***** Intercepted Retail Bank Account Response *****");
            var response =  exchange.getResponse();
            var headers = response.getHeaders();
            headers.forEach((key,value) -> {
                log.info( "Key is {}  and value is {}", key, value);
            });
            log.info("Response Status code is : {}" , response.getStatusCode());
        }));

    }

    @Getter
    @Setter
    public static class Config{
        private String name;
    }
}
