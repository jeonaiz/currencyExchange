package kg.esep.services.impl;

import kg.esep.dao.CurrencyExchangeRepository;
import kg.esep.models.CurrencyExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kg.esep.services.CurrencyExchangeService;

import java.util.List;
import java.util.Optional;


@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService
{

    private final CurrencyExchangeRepository currencyExchangeRepository;

    @Autowired
    public CurrencyExchangeServiceImpl(CurrencyExchangeRepository currencyExchangeRepository) {
        this.currencyExchangeRepository = currencyExchangeRepository;
    }

    @Override
    public CurrencyExchange saveCurrencyExchange( CurrencyExchange currencyExchange ) {
        return currencyExchangeRepository.save(currencyExchange);
    }

    @Override
    public List<CurrencyExchange> getAllCurrencyExchanges() {
        return currencyExchangeRepository.findAll();
    }

    @Override
    public Optional<CurrencyExchange> getCurrencyExchangeById(Long id) {
        return currencyExchangeRepository.findById(id);
    }

    @Override
    public CurrencyExchange updateCurrencyExchange(Long id, CurrencyExchange updatedCurrencyExchange) {
        Optional<CurrencyExchange> existingCurrencyExchangeOptional = currencyExchangeRepository.findById(id);

        if (existingCurrencyExchangeOptional.isPresent()) {
            CurrencyExchange existingCurrencyExchange = existingCurrencyExchangeOptional.get();
            existingCurrencyExchange.setExchangeRate(updatedCurrencyExchange.getExchangeRate());

            return currencyExchangeRepository.save(existingCurrencyExchange);
        }
        return null;
    }
}
