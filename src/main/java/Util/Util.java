package Util;

import com.reactor.challenge.app.domain.Currency;
import dto.ResponseExchangeDto;

import java.math.BigDecimal;

public class Util {

    public static ResponseExchangeDto convertByRate(Currency exchangeRate, String amount) {
        BigDecimal amountDecimal=BigDecimal.valueOf(Double.valueOf(amount));
        BigDecimal result = amountDecimal.multiply(BigDecimal.valueOf(Double.valueOf(exchangeRate.getValue())));
        return new ResponseExchangeDto(amount,exchangeRate.getOriginCurrency(), exchangeRate.getDestinationCurrency(), result.toString(),exchangeRate.getValue());
    }
}
