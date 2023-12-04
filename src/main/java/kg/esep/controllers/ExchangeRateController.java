package kg.esep.controllers;


import kg.esep.models.ExchangeRate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import kg.esep.services.ExchangeRateService;

import java.util.List;


@RestController
@RequestMapping("/api/exchange-rates")
public class ExchangeRateController {
    private final ExchangeRateService exchangeRateService;

    @Autowired
    public ExchangeRateController(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @GetMapping
    public List<ExchangeRate> getAllExchangeRates() {
        return exchangeRateService.getAllExchangeRates();
    }

    @GetMapping("/{exchangeRate_id}")
    public ExchangeRate getExchangeRateById(@PathVariable Long id) {
        return exchangeRateService.getExchangeRateById(id);
    }

}
