package controllers;

import models.MoneyBalance;
import services.MoneyBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/money-balances")
public class MoneyBalanceController {
    private final MoneyBalanceService moneyBalanceService;

    @Autowired
    public MoneyBalanceController(MoneyBalanceService moneyBalanceService) {
        this.moneyBalanceService = moneyBalanceService;
    }

    @GetMapping
    public List<MoneyBalance> getAllMoneyBalances() {
        return moneyBalanceService.getAllMoneyBalances();
    }

    @GetMapping("/{moneyBalance_id}")
    public MoneyBalance getMoneyBalanceById(@PathVariable Long id) {
        return moneyBalanceService.getMoneyBalanceById(id);
    }

}
