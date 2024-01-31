package com.pravyuha.currencyexchangeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class CurrencyExchangeServiceApplication {

	public static void main(String[] args) {
			SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
	}

}
