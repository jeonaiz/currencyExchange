package controllers;

import models.MoneyTransaction;
import services.MoneyTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/money-transactions")
public class MoneyTransactionController {
    private final MoneyTransactionService moneyTransactionService;

    @Autowired
    public MoneyTransactionController(MoneyTransactionService moneyTransactionService) {
        this.moneyTransactionService = moneyTransactionService;
    }

    @GetMapping
    public List<MoneyTransaction> getAllMoneyTransactions() {
        return moneyTransactionService.getAllMoneyTransactions();
    }

    @GetMapping("/{moneyTransaction_id}")
    public MoneyTransaction getMoneyTransactionById(@PathVariable Long id) {
        return moneyTransactionService.getMoneyTransactionById(id);
    }

}
