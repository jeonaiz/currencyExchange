package kg.esep.services;

import kg.esep.enums.TransactionType;


public interface CurrencyTransactionService {
    void processCurrencyTransaction(String fromCurrencyCode, String toCurrencyCode, double amount, double exchangeRate, TransactionType transactionType);
}

