package dao;

import models.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
    // Дополнительные методы для работы с базой данных
}
