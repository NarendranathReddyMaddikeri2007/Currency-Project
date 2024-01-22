package com.pravyuha.currencyexchangeservice.service;

import com.pravyuha.currencyexchangeservice.bean.Currencyexchange;

public interface CurrencyExchangeService {
    Currencyexchange retrieveExchangeValue(String from, String to);
}
