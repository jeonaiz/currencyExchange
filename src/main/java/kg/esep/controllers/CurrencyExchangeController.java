package kg.esep.controllers;

import kg.esep.models.CurrencyExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import kg.esep.services.CurrencyExchangeService;


@Controller
@RequestMapping("/api/currency-exchanges")
public class CurrencyExchangeController {

    private final CurrencyExchangeService currencyExchangeService;
    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public CurrencyExchangeController(CurrencyExchangeService currencyExchangeService, SimpMessagingTemplate messagingTemplate) {
        this.currencyExchangeService = currencyExchangeService;
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/create-currency-exchange")
    @SendTo("/topic/currency-exchanges")
    public CurrencyExchange createCurrencyExchange(@RequestBody CurrencyExchange request) {
        CurrencyExchange savedExchange = currencyExchangeService.saveCurrencyExchange(request);
        return savedExchange;
    }

    @GetMapping
    public String getAllCurrencyExchanges() {
        return "currency_exchangePort";
    }
}
