package com.pravyuha.currencyexchangeservice.service;

import com.pravyuha.currencyexchangeservice.repository.CurrencyExchangeRepository;
import com.pravyuha.currencyexchangeservice.bean.Currencyexchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;


@Service
@Transactional
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService{

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @Autowired
    private Environment environment;

    @Override
    public Currencyexchange retrieveExchangeValue(String from, String to) {
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
