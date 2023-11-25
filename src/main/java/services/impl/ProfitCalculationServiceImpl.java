//package services.impl;
//
//import dao.CurrencyExchangeRepository;
//import dao.CurrencyTransactionRepository;
//import enums.TransactionType;
//import models.Currency;
//import models.CurrencyExchange;
//import models.CurrencyTransaction;
//import models.ExchangeRate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import services.ProfitCalculationService;
//
//import java.util.Optional;
//
//@Service
//public class ProfitCalculationServiceImpl implements ProfitCalculationService {
//
//    private final CurrencyExchangeRepository exchangeRepository;
//    private final CurrencyTransactionRepository transactionRepository;
//
//    @Autowired
//    public ProfitCalculationServiceImpl(CurrencyExchangeRepository exchangeRepository, CurrencyTransactionRepository transactionRepository) {
//        this.exchangeRepository = exchangeRepository;
//        this.transactionRepository = transactionRepository;
//    }
//
//    @Override
//    public double calculateProfit(String fromCurrencyCode, String toCurrencyCode, double amount, double exchangeRate, TransactionType transactionType) {
//        Currency currency = getOrCreateCurrency(fromCurrencyCode, toCurrencyCode);
//
//        double costPrice = calculateCostPrice(currency);
//        double profit = calculateProfit(amount, exchangeRate, costPrice, transactionType);
//
//        CurrencyTransaction transaction = createCurrencyTransaction(fromCurrencyCode, toCurrencyCode, amount, profit, transactionType);
//        saveCurrencyTransaction(transaction);
//
//        return profit;
//    }
//
//    private CurrencyExchange getOrCreateCurrencyExchange(String fromCurrency, String toCurrency) {
//        Optional<CurrencyExchange> exchangeOptional = exchangeRepository.findByFromCurrencyCodeAndToCurrencyCode(fromCurrency, toCurrency);
//        return exchangeOptional.orElseGet(() -> exchangeRepository.save(new CurrencyExchange(fromCurrency, toCurrency)));
//    }
//
//    private double calculateCostPrice(ExchangeRate rate) {
//        return (rate.getBuyingRate() + rate.getSellingRate()) / 2.0;
//    }
//
//    private double calculateProfit(double amount, double exchangeRate, double costPrice, TransactionType transactionType) {
//        if (transactionType == TransactionType.SELL) {
//            return (exchangeRate - costPrice) * amount;
//        }
//        return 0;
//    }
//    private void saveCurrencyTransaction(CurrencyTransaction transaction) {
//        transactionRepository.save(transaction);
//    }
//}
