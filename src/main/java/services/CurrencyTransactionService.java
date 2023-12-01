package services;

import java.util.List;

import enums.TransactionType;
import models.CurrencyTransaction;

public interface CurrencyTransactionService {
    void processCurrencyTransaction(String fromCurrencyCode, String toCurrencyCode, double amount, double exchangeRate, TransactionType transactionType);
}

