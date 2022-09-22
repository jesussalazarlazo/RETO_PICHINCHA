package com.reactor.challenge.app.services;

import com.reactor.challenge.app.domain.Currency;
import dto.ResponseExchangeDto;
import io.reactivex.Single;

import java.util.List;
import java.util.Optional;

public interface CurrencyService {

    List<Currency> findAll();
    Currency save(Currency currency);
    Optional<Currency> findById(Long id);
    void deleteAll();
    Single<ResponseExchangeDto> exchangeCurrency(String originCurrency, String destinationCurrency, String amount);
}
