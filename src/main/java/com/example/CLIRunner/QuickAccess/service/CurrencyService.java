package com.example.CLIRunner.QuickAccess.service;

import com.example.CLIRunner.QuickAccess.exception.ExchangeRateNotFoundException;
import com.example.CLIRunner.QuickAccess.model.ConversionRequest;

import java.math.BigDecimal;
import java.util.Map;

public interface CurrencyService {

    public Map<String, BigDecimal> currencyConvertor(ConversionRequest req) throws ExchangeRateNotFoundException;
}
