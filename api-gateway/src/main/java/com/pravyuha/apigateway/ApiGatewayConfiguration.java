package com.pravyuha.apigateway;


import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder){
        //return builder.routes().build(); for normal routes
        // redirect to this uri
        //Check in this url: http://localhost:8765/get
        //In addition to redirect, we want to add header or path parameter
        return builder.routes()
                .route(p->p.path("/get") // if p is the predicate, if path is /get then
                .filters(f-> f
                        .addRequestHeader("MyHeader","MyURI")
                        .addRequestParameter("Param","MyValue")
                )
                .uri("http://httpbin.org:80"))
                .route(p->p.path("/currency-exchange/**")
                        .uri("lb://currency-exchange"))
                .route(p->p.path("/currency-conversion/**")
                        .uri("lb://currency-conversion"))
                .route(p->p.path("/currency-conversion-feign/**")
                        .uri("lb://currency-conversion"))
                .route(p->p.path("/currency-conversion-new/**")
                        .filters(f->f.rewritePath(
                                "/currency-conversion-new/(?<segment>.*)",
                                "/currency-conversion-feign/${segment}")
                        )
                        .uri("lb://currency-conversion"))
                .build();
    }
}
/*
 Function<PredicateSpec, Buildable<Route>> routeFunction
                = p->p.path("/get") // if p is the predicate, if path is /get then
                .filters(f-> f
                        .addRequestHeader("MyHeader","MyURI")
                        .addRequestParameter("Param","MyValue")
                )
                .uri("http://httpbin.org:80"); // redirect to this uri
        //Check in this url: http://localhost:8765/get
        //In addition to redirect, we want to add header or path parameter

 Make this routeFunction as inline. Select variable -> Refactor -> Inline Variable
 */
