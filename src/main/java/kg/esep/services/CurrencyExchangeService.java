package kg.esep.services;

import kg.esep.models.CurrencyExchange;

import java.util.List;
import java.util.Optional;

public interface CurrencyExchangeService {
    CurrencyExchange saveCurrencyExchange(CurrencyExchange currencyExchange);
    CurrencyExchange updateCurrencyExchange(Long id, CurrencyExchange updatedCurrencyExchange);
    List<CurrencyExchange> getAllCurrencyExchanges();
    Optional<CurrencyExchange> getCurrencyExchangeById(Long id);

}
