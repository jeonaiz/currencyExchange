package services.impl;

import dao.CurrencyRepository;
import dao.CurrencyTransactionRepository;
import enums.TransactionType;
import models.Currency;
import models.CurrencyTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.CurrencyTransactionService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CurrencyTransactionServiceImpl implements CurrencyTransactionService {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private CurrencyTransactionRepository transactionRepository;

    @Override
    public void processCurrencyTransaction(String fromCurrencyCode, String toCurrencyCode, double amount, double exchangeRate, TransactionType transactionType) {
        Optional<Currency> fromCurrencyOptional = currencyRepository.findByCode(fromCurrencyCode);
        Optional<Currency> toCurrencyOptional = currencyRepository.findByCode(toCurrencyCode);

        if (fromCurrencyOptional.isPresent() && toCurrencyOptional.isPresent()) {
            Currency fromCurrency = fromCurrencyOptional.get();
            Currency toCurrency = toCurrencyOptional.get();

            double convertedAmount = calculateConvertedAmount(amount, exchangeRate, transactionType);

            CurrencyTransaction transaction = new CurrencyTransaction();
            transaction.setFromCurrency(fromCurrency);
            transaction.setToCurrency(toCurrency);
            transaction.setAmount(amount);
            transaction.setExchangeRate(exchangeRate);
            transaction.setConvertedAmount(convertedAmount);
            transaction.setTransactionType(transactionType);
            transaction.setTransactionTime(LocalDateTime.now());

            transactionRepository.save(transaction);
        } else {
            throw new RuntimeException("Currency not found");
        }
    }

    private double calculateConvertedAmount(double amount, double exchangeRate, TransactionType transactionType) {
        if (transactionType == TransactionType.BUY) {
            return amount * exchangeRate;
        } else if (transactionType == TransactionType.SELL) {
            return amount / exchangeRate;
        }
        throw new IllegalArgumentException("Invalid transaction type");
    }

    public double calculateProfit() {
        List<CurrencyTransaction> allTransactions = transactionRepository.findAll();

        double totalProfit = 0.0;

        for (CurrencyTransaction transaction : allTransactions) {
            double profitForTransaction = calculateProfitForTransaction(transaction);
            totalProfit += profitForTransaction;
        }

        return totalProfit;
    }

    private double calculateProfitForTransaction(CurrencyTransaction transaction) {
        if (transaction.getTransactionType() == TransactionType.BUY) {

            return 0.0;
        } else if (transaction.getTransactionType() == TransactionType.SELL) {
            double profit = transaction.getConvertedAmount() - transaction.getAmount();
            return profit;
        }

        throw new IllegalArgumentException("Invalid transaction type");
    }
}






















