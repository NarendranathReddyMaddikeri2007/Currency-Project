package com.pravyuha.currencyconversionservice.others;

import com.pravyuha.currencyconversionservice.bean.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//We want the Feign client to talk to the eureka and pickup instances of CurrencyExchange and do load-balancing.

//@FeignClient(name = "currency-exchange", url = "localhost:8000"), after removing it, still it'll run because we connected with eureka server
@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {


    @GetMapping(path = "/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion retrieveExchangeValue(
            @PathVariable String from,
            @PathVariable String to);

}
