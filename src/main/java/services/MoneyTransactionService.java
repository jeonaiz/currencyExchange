package services;

import java.util.List;
import models.MoneyTransaction;

public interface MoneyTransactionService {
    List<MoneyTransaction> getAllMoneyTransactions();

    MoneyTransaction getMoneyTransactionById(Long id);

}
