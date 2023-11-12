package dao;


import models.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {
    // Здесь вы можете добавить дополнительные методы, если они потребуются
}
