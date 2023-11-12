package controllers;

import models.CurrencyExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.CurrencyExchangeService;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/currency-exchanges")
public class CurrencyExchangeController {
    private final CurrencyExchangeService currencyExchangeService;

    @Autowired
    public CurrencyExchangeController(CurrencyExchangeService currencyExchangeService) {
        this.currencyExchangeService = currencyExchangeService;
    }

    @PostMapping
    public ResponseEntity<CurrencyExchange> createCurrencyExchange(@RequestBody CurrencyExchange request) {

        CurrencyExchange currencyExchange = new CurrencyExchange();

        CurrencyExchange savedExchange = currencyExchangeService.saveCurrencyExchange(currencyExchange);
        return new ResponseEntity<>(savedExchange, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CurrencyExchange>> getAllCurrencyExchanges() {
        List<CurrencyExchange> exchanges = currencyExchangeService.getAllCurrencyExchanges();
        return new ResponseEntity<>(exchanges, HttpStatus.OK);
    }

    @GetMapping("/{currencyExchange_id}")
    public ResponseEntity<CurrencyExchange> getCurrencyExchangeById(@PathVariable Long id) {
        Optional<CurrencyExchange> optionalExchange = currencyExchangeService.getCurrencyExchangeById(id);

        if (optionalExchange.isPresent()) {
            return new ResponseEntity<>(optionalExchange.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
