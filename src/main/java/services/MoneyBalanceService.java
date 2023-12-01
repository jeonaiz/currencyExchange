package services;

import models.MoneyBalance;

import java.util.List;

public interface MoneyBalanceService {
    List<MoneyBalance> getAllMoneyBalances();
    MoneyBalance getMoneyBalanceById(Long id);

    MoneyBalance saveMoneyBalance(MoneyBalance moneyBalance);

    MoneyBalance updateMoneyBalance(Long id, MoneyBalance updatedMoneyBalance);

    void deleteMoneyBalance(Long id);
}
