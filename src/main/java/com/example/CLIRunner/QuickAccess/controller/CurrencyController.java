package com.example.CLIRunner.QuickAccess.controller;

import com.example.CLIRunner.QuickAccess.exception.ExchangeRateNotFoundException;
import com.example.CLIRunner.QuickAccess.model.ConversionRequest;
import com.example.CLIRunner.QuickAccess.service.CurrencyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Map;

@RestController
@RequestMapping
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("convertCurrency")
    public Map<String, BigDecimal> currencyConverter(@RequestParam BigDecimal amount, @RequestParam String baseCurrency)
            throws ExchangeRateNotFoundException {

        ConversionRequest conversionRequest = new ConversionRequest(amount,baseCurrency);
        return currencyService.currencyConvertor(conversionRequest);
    }
}
