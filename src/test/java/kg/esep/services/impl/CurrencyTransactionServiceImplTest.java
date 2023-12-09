package kg.esep.services.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import kg.esep.dao.CurrencyRepository;
import kg.esep.dao.CurrencyTransactionRepository;
import kg.esep.enums.TransactionType;
import kg.esep.models.Currency;
import kg.esep.models.CurrencyTransaction;
import kg.esep.services.impl.CurrencyTransactionServiceImpl;

class CurrencyTransactionServiceImplTest {

    @Mock
    private CurrencyRepository currencyRepository;

    @Mock
    private CurrencyTransactionRepository transactionRepository;

    @InjectMocks
    private CurrencyTransactionServiceImpl transactionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testProcessCurrencyTransaction() {

        String fromCurrencyCode = "USD";
        String toCurrencyCode = "KGS";
        double amount = 100.0;
        double exchangeRate = 88.5;
        TransactionType transactionType = TransactionType.BUY;

        Currency fromCurrency = new Currency();
        fromCurrency.setCode(fromCurrencyCode);

        Currency toCurrency = new Currency();
        toCurrency.setCode(toCurrencyCode);

        CurrencyTransaction savedTransaction = new CurrencyTransaction();
        savedTransaction.setFromCurrency(fromCurrency);
        savedTransaction.setToCurrency(toCurrency);
        savedTransaction.setAmount(amount);
        savedTransaction.setExchangeRate(exchangeRate);
        savedTransaction.setConvertedAmount(amount * exchangeRate);
        savedTransaction.setTransactionType(transactionType);
        savedTransaction.setTransactionTime(LocalDateTime.now());

        when(currencyRepository.findByCode(fromCurrencyCode)).thenReturn(Optional.of(fromCurrency));
        when(currencyRepository.findByCode(toCurrencyCode)).thenReturn(Optional.of(toCurrency));
        when(transactionRepository.save(any(CurrencyTransaction.class))).thenReturn(savedTransaction);


        transactionService.processCurrencyTransaction(fromCurrencyCode, toCurrencyCode, amount, exchangeRate, transactionType);


        verify(transactionRepository, times(1)).save(any(CurrencyTransaction.class));
    }

    @Test
    void testCalculateProfit() {

        CurrencyTransaction transaction1 = new CurrencyTransaction();
        transaction1.setTransactionType(TransactionType.BUY);
        transaction1.setConvertedAmount(0.0);

        CurrencyTransaction transaction2 = new CurrencyTransaction();
        transaction2.setTransactionType(TransactionType.SELL);
        transaction2.setAmount(100.0);
        transaction2.setConvertedAmount(8950.0);

        List<CurrencyTransaction> allTransactions = Arrays.asList(transaction1, transaction2);

        when(transactionRepository.findAll()).thenReturn(allTransactions);

        double profit = transactionService.calculateProfit();

        assertEquals(100.0, profit);
    }
}
