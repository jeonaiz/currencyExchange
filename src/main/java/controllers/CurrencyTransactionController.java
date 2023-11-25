package controllers;

import enums.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import services.CurrencyTransactionService;

@Controller
public class CurrencyTransactionController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private CurrencyTransactionService transactionService;

    @MessageMapping("/buy")
    public void buyCurrency(@RequestParam String fromCurrency,
                            @RequestParam String toCurrency,
                            @RequestParam double amount,
                            @RequestParam double exchangeRate) {
        transactionService.processCurrencyTransaction(fromCurrency, toCurrency, amount, exchangeRate, TransactionType.BUY);
        messagingTemplate.convertAndSend("/topic/transactionResult", "Purchase transaction processed successfully");
    }

    @MessageMapping("/sell")
    public void sellCurrency(@RequestParam String fromCurrency,
                             @RequestParam String toCurrency,
                             @RequestParam double amount,
                             @RequestParam double exchangeRate) {
        transactionService.processCurrencyTransaction(fromCurrency, toCurrency, amount, exchangeRate, TransactionType.SELL);
        messagingTemplate.convertAndSend("/topic/transactionResult", "Sale transaction processed successfully");
    }
}
