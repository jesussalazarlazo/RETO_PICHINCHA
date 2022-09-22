package com.reactor.challenge.app.services;

import Util.Util;
import com.reactor.challenge.app.domain.Currency;
import com.reactor.challenge.app.repositories.CurrencyRepository;
import dto.ResponseExchangeDto;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    public List<Currency> findAll() {
        List<Currency> currencyList = currencyRepository.findAll();
        return currencyList;
    }

    @Override
    public Currency save(Currency currency) {
        Currency currencySaved = currencyRepository.save(currency);
        return currencySaved;
    }

    @Override
    public Optional<Currency> findById(Long id) {
        return currencyRepository.findById(id);
    }

    @Override
    public void deleteAll() {
        currencyRepository.deleteAll();
    }

    @Override
    public Single<ResponseExchangeDto> exchangeCurrency
            (String originCurrency, String destinationCurrency, String amount) {
        List<Currency> listCurrency = currencyRepository.findByoriginCurrencyAndDestinationCurrency(originCurrency, destinationCurrency);

        if (listCurrency.size() > 0) {
            return Single.create(singleSubscriber -> {
                ResponseExchangeDto exchange = Util.convertByRate(listCurrency.get(0), amount);
                singleSubscriber.onSuccess(exchange);
            });
        } else {
            return Single.create(singleSubscriber -> {
                singleSubscriber.onSuccess(new ResponseExchangeDto());
            });
        }
    }


}
