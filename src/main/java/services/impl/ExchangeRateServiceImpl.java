package services.impl;

import models.ExchangeRate;
import dao.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.ExchangeRateService;

import java.util.List;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {
    private final ExchangeRateRepository exchangeRateRepository;

    @Autowired
    public ExchangeRateServiceImpl(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }

    @Override
    public List<ExchangeRate> getAllExchangeRates() {
        return exchangeRateRepository.findAll();
    }

    @Override
    public ExchangeRate getExchangeRateById(Long id) {
        return exchangeRateRepository.findById(id).orElse(null);
    }

}
