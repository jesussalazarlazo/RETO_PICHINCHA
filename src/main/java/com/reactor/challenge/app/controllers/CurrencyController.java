package com.reactor.challenge.app.controllers;


import com.reactor.challenge.app.domain.Currency;
import com.reactor.challenge.app.exceptions.CurrencyNotFoundException;
import com.reactor.challenge.app.services.CurrencyService;
import dto.ResponseExchangeDto;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    private CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/get")
    public ResponseEntity<?> all() {
        HttpStatus status = HttpStatus.OK;
        List<Currency> Litscurrency = currencyService.findAll().stream()
                .collect(Collectors.toList());
        return new ResponseEntity<>(Litscurrency, status);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> replaceCurrency(@RequestBody Currency body, @PathVariable Long id) {
        currencyService.findById(id)
                .map(currency -> {
                    currency.setValue(body.getValue());
                    return currencyService.save(currency);
                })
                .orElseThrow(() -> new CurrencyNotFoundException(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/exchange")
    public Single<ResponseEntity<BaseWebResponse<ResponseExchangeDto>>> getExchangeRate(
            @Param("originCurrency") String originCurrency,
            @Param("destinationCurrency") String destinationCurrency,
            @Param("amount") String amount)  {

        return currencyService.exchangeCurrency(originCurrency,destinationCurrency,amount)
                .subscribeOn(Schedulers.io())
                .map(exchangeRateResult -> ResponseEntity.ok(BaseWebResponse.successWithData(exchangeRateResult)));

    }

}
