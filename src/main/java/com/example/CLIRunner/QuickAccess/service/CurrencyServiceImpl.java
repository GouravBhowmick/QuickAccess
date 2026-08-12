package com.example.CLIRunner.QuickAccess.service;

import com.example.CLIRunner.QuickAccess.exception.ExchangeRateNotFoundException;
import com.example.CLIRunner.QuickAccess.model.ConversionRequest;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    private static final Map<String, BigDecimal> exchangeRateMap = Map.of(
            "USD", new BigDecimal("1.00"),
            "EUR", new BigDecimal("0.92"),
            "GBP", new BigDecimal("0.79"),
            "INR", new BigDecimal("87.50"),
            "JPY", new BigDecimal("148.30"),
            "AUD", new BigDecimal("1.53"),
            "CAD", new BigDecimal("1.37"),
            "CHF", new BigDecimal("0.81")
    );

    /*200 INR
    * 200 / 87.50 = 2.28 USD  converted to USD
    * 2.28 USD * 0.92 = 2.10 EUR
    * */

    @Override
    public Map<String, BigDecimal> currencyConvertor(ConversionRequest req) throws ExchangeRateNotFoundException {

        String baseCurrency = req.getBaseCurrency();
        BigDecimal amount =  req.getAmount();
        if(!exchangeRateMap.containsKey(baseCurrency)){
            throw new ExchangeRateNotFoundException("Exchange rate not maintained");
        }
        Map<String, BigDecimal> exchangeAmountMap = new HashMap<>();
        BigDecimal convertedToUS = amount.divide(exchangeRateMap.get(baseCurrency), 8, RoundingMode.HALF_DOWN);
        for(Map.Entry<String, BigDecimal> fxRate : exchangeRateMap.entrySet()){

            if(!baseCurrency.equalsIgnoreCase(fxRate.getKey())){

                BigDecimal exchangedAmount = convertedToUS.multiply(fxRate.getValue());

                exchangeAmountMap.put(fxRate.getKey(), exchangedAmount);

            }
            else
                exchangeAmountMap.put(baseCurrency, amount);
        }
        return exchangeAmountMap;
    }
}
