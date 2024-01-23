package com.pravyuha.currencyexchangeservice.controller;


import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//To implement simple REST API here for circuit breaking.
@RestController
public class CircuitBreakerController {

    /*
    1) Retry - Retry requests for specific times with specific time interval.
    2) Circuit Breaker - If microservice which request was sent is down.
                       - if any forward microservices breaks, it'll throw default response to backward.
    3) Rate Limiting - In certain seconds (10s), allow only specific no.of calls (100 calls) to sample api.
    4) BulkHead - How many concurrent calls are allowed.

     */
    private final Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
    //@Retry(name = "sample-api", fallbackMethod = "hardcodedResponse") //By default, 3 times retry will happen
    //@CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
    //@RateLimiter(name = "default")

    @Bulkhead(name = "default")
    @GetMapping(path = "/sample-api")
    public String sampleApi(){
        logger.info("Sample api call received");
        System.out.print("\n------------ SAMPLE API CALL RECEIVED------------\n");
        //Below request to other microservice will be failed. Implement retry feature here.
        //We can say that, microservice will be down temporarily.
//        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", String.class);

        return "sample-api";
    }

    public String hardcodedResponse(Exception ex){
        return "fallback-response";
    }

}
