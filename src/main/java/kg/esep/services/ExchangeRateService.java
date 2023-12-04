package kg.esep.services;

import kg.esep.models.ExchangeRate;

import java.util.List;


public interface ExchangeRateService {
    List<ExchangeRate> getAllExchangeRates();

    ExchangeRate getExchangeRateById(Long id);

}
