package services;

import models.CurrencyExchange;

import java.util.List;
import java.util.Optional;

public interface CurrencyExchangeService {
    CurrencyExchange saveCurrencyExchange(CurrencyExchange currencyExchange);
    List<CurrencyExchange> getAllCurrencyExchanges();
    Optional<CurrencyExchange> getCurrencyExchangeById(Long id);
    // Другие методы, если необходимо
}
