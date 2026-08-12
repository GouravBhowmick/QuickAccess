package com.example.CLIRunner.QuickAccess.model;

import java.math.BigDecimal;

public class ConversionRequest {


    private BigDecimal amount;

    private String baseCurrency;

    public ConversionRequest(BigDecimal amount, String baseCurrency) {
        this.amount = amount;
        this.baseCurrency = baseCurrency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }
}
