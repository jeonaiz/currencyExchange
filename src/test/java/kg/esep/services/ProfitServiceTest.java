package kg.esep.services;

import kg.esep.enums.TransactionType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import kg.esep.dao.ProfitRepository;
import kg.esep.models.CurrencyTransaction;
import kg.esep.models.Profit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ProfitServiceTest {

    private ProfitService profitService;
    private ProfitRepository profitRepository;

    @BeforeEach
    void setUp() {
        profitRepository = mock(ProfitRepository.class);
        profitService = new ProfitService(profitRepository);
    }

    @Test
    void calculateAndSaveProfit() {
        CurrencyTransaction transaction = new CurrencyTransaction();
        transaction.setAmount(100.0);
        transaction.setPurchaseAmount(88.0);
        transaction.setExchangeRate(89.7);
        transaction.setTransactionType(TransactionType.SELL);

        when(profitRepository.save(Mockito.any(Profit.class))).thenReturn(new Profit());

        double result = profitService.calculateAndSaveProfit(transaction);

        double expected = (100.0 * 89.7) - (88.0*100.0);

        assertEquals(expected, result);
    }
}
