package com.reactor.challenge.app.jwt.config;


import com.reactor.challenge.app.domain.Currency;
import com.reactor.challenge.app.services.CurrencyService;
import io.reactivex.subjects.BehaviorSubject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfiguration {


    @Bean
    public CommandLineRunner loadData(CurrencyService currencyService) {
        return (args) -> {
            currencyService.deleteAll();

            currencyService.save(new Currency("USD", "PEN", "3.5"));
            currencyService.save(new Currency("PEN", "USD", "0.285714"));


        };
    }
}
