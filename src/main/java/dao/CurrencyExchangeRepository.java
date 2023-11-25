package dao;

import models.Currency;
import models.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

    Optional<CurrencyExchange> findByFromCurrencyCodeAndToCurrencyCode(String fromCurrencyCode, String toCurrencyCode);
}
