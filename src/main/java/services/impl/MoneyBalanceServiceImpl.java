package services.impl;

import dao.MoneyBalanceRepository;
import models.MoneyBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.MoneyBalanceService;

import java.util.List;

@Service
public class MoneyBalanceServiceImpl implements MoneyBalanceService {

    private final MoneyBalanceRepository moneyBalanceRepository;

    @Autowired
    public MoneyBalanceServiceImpl(MoneyBalanceRepository moneyBalanceRepository) {
        this.moneyBalanceRepository = moneyBalanceRepository;
    }

    @Override
    public List<MoneyBalance> getAllMoneyBalances() {
        return moneyBalanceRepository.findAll();
    }

    @Override
    public MoneyBalance getMoneyBalanceById(Long id) {
        return moneyBalanceRepository.findById(id).orElse(null);
    }

    @Override
    public MoneyBalance saveMoneyBalance(MoneyBalance moneyBalance) {
        return moneyBalanceRepository.save(moneyBalance);
    }

    @Override
    public MoneyBalance updateMoneyBalance(Long id, MoneyBalance updatedMoneyBalance) {
        MoneyBalance existingMoneyBalance = moneyBalanceRepository.findById(id).orElse(null);

        if (existingMoneyBalance != null) {
            existingMoneyBalance.setAmount(updatedMoneyBalance.getAmount());
            return moneyBalanceRepository.save(existingMoneyBalance);
        }

        return null;
    }

    @Override
    public void deleteMoneyBalance(Long id) {
        moneyBalanceRepository.deleteById(id);
    }
}
