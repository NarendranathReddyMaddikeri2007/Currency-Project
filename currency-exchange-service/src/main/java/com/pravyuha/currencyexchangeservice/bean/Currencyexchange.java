package com.pravyuha.currencyexchangeservice.bean;



import jakarta.persistence.*;

import java.math.BigDecimal;


@Entity
@Table(name = "currencyexchanges")
public class Currencyexchange {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String currency_from;
    private String currency_to;
     private BigDecimal conversionMultiple;
     private String environment;//For case of load balancing & naming server

    public Currencyexchange() {
           super();
    }

    public Currencyexchange(Long id, String from, String to, BigDecimal conversionMultiple) {
        super();
        this.id = id;
        this.currency_from = from;
        this.currency_to = to;
        this.conversionMultiple = conversionMultiple;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return currency_from;
    }

    public void setFrom(String from) {
        this.currency_from = from;
    }

    public String getTo() {
        return currency_to;
    }

    public void setTo(String to) {
        this.currency_to = to;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    @Override
    public String toString() {
        return "Currencyexchange{" +
                "id=" + id +
                ", from='" + currency_from + '\'' +
                ", to='" + currency_to + '\'' +
                ", conversionMultiple=" + conversionMultiple +
                ", environment='" + environment + '\'' +
                '}';
    }
}
