package services.impl;

import models.MoneyTransaction;
import dao.MoneyTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.MoneyTransactionService;

import java.util.List;

@Service
public class MoneyTransactionServiceImpl implements MoneyTransactionService {
    private final MoneyTransactionRepository moneyTransactionRepository;

    @Autowired
    public MoneyTransactionServiceImpl(MoneyTransactionRepository moneyTransactionRepository) {
        this.moneyTransactionRepository = moneyTransactionRepository;
    }

    @Override
    public List<MoneyTransaction> getAllMoneyTransactions() {
        return moneyTransactionRepository.findAll();
    }

    @Override
    public MoneyTransaction getMoneyTransactionById(Long id) {
        return moneyTransactionRepository.findById(id).orElse(null);
    }

}
