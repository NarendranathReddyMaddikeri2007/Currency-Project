package com.pravyuha.currencyexchangeservice.repository;

import com.pravyuha.currencyexchangeservice.bean.Currencyexchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<Currencyexchange,Long> {



    @Query("SELECT DISTINCT c from Currencyexchange c where c.currency_from LIKE %?1% AND c.currency_to LIKE %?2%")
    List<Currencyexchange> findByFromAndTo(String from, String to);
}
