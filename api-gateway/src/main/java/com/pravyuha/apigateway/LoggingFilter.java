package com.pravyuha.apigateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


@Component
public class LoggingFilter implements GlobalFilter {

    private Logger logger = LoggerFactory.getLogger(LoggingFilter.class);


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("Pathof the request received -> "+exchange.getRequest().getPath());

        System.out.print("\n-----------------\n");
        System.out.print("Path of the request received -> "+exchange.getRequest().getPath());
        System.out.print("\n-----------------\n");
        System.out.print("\n\n");

        return chain.filter(exchange);
    }
}
