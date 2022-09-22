package com.reactor.challenge.app.exceptions;

public class CurrencyNotFoundException extends RuntimeException{

    private final static String NOT_FOUND_CURRENCY = "Not found currencyId : ";

    public CurrencyNotFoundException(Long id) {
        super(NOT_FOUND_CURRENCY + id);
    }

}
