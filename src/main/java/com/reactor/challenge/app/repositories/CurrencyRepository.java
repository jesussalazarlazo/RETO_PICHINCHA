package com.reactor.challenge.app.repositories;

import com.reactor.challenge.app.domain.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {

    List<Currency> findByoriginCurrencyAndDestinationCurrency(String originCurrency, String destinationCurrency);

}
