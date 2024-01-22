package com.pravyuha.currencyexchangeservice.controller;


import com.pravyuha.currencyexchangeservice.bean.Currencyexchange;
import com.pravyuha.currencyexchangeservice.repository.CurrencyExchangeRepository;
import com.pravyuha.currencyexchangeservice.service.CurrencyExchangeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @Autowired
    private Environment environment;

    @GetMapping(path = "/currency-exchange/from/{from}/to/{to}")
    public Currencyexchange retrieveExchangeValue(
            @PathVariable String from,
            @PathVariable String to){
        String port = environment.getProperty("local.server.port");
        Currencyexchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from, to).get(0);
        if(currencyExchange==null){
            throw new RuntimeException("Unable to Find data for "+from+" & to "+to);
        }
        System.out.println("\n\n\n");
        System.out.println(currencyExchange.toString());
        System.out.println("\n\n\n");
        currencyExchange.setEnvironment(port);
        return currencyExchange;
    }

}
