package services;

import enums.TransactionType;

public interface ProfitCalculationService {
    double calculateProfit(String fromCurrencyCode, String toCurrencyCode, double amount, double exchangeRate, TransactionType transactionType);
}
