package com.pravyuha.currencyconversionservice.bean;

import org.springframework.cglib.core.Local;

import java.math.BigInteger;


public class CurrencyConversion {

    private Long id;
    private String currency_from;
    private String currency_to;
    private BigInteger quantity;
    private BigInteger conversionMultiple;
    private BigInteger totalCalculatedAmount;
    private String environment;

    public CurrencyConversion(){
        super();
    }

    public CurrencyConversion(Long id, String currency_from, String currency_to, BigInteger conversionMultiple, BigInteger quantity, BigInteger totalCalculatedAmount, String environment) {
        super();
        this.id = id;
        this.currency_from = currency_from;
        this.currency_to = currency_to;
        this.conversionMultiple = conversionMultiple;
        this.quantity = quantity;
        this.totalCalculatedAmount = totalCalculatedAmount;
        this.environment = environment;
    }

    public CurrencyConversion(Long id, String from, String to, BigInteger conversionMultiple, BigInteger totalCalculatedAmount, String environment) {
       this.id = id;
       this.currency_from = from;
       this.currency_to = to;
       this.conversionMultiple = conversionMultiple;
       this.totalCalculatedAmount = totalCalculatedAmount;
       this.environment = environment;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency_from() {
        return currency_from;
    }

    public void setCurrency_from(String currency_from) {
        this.currency_from = currency_from;
    }

    public String getCurrency_to() {
        return currency_to;
    }

    public void setCurrency_to(String currency_to) {
        this.currency_to = currency_to;
    }

    public BigInteger getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigInteger conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

    public BigInteger getTotalCalculatedAmount() {
        return totalCalculatedAmount;
    }

    public void setTotalCalculatedAmount(BigInteger totalCalculatedAmount) {
        this.totalCalculatedAmount = totalCalculatedAmount;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    @Override
    public String toString() {
        return "CurrencyConversion{" +
                "id=" + id +
                ", currency_from='" + currency_from + '\'' +
                ", currency_to='" + currency_to + '\'' +
                ", conversionMultiple=" + conversionMultiple +
                ", quantity=" + quantity +
                ", totalCalculatedAmount=" + totalCalculatedAmount +
                ", environment='" + environment + '\'' +
                '}';
    }
}
