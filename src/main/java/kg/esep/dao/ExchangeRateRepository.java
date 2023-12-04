package kg.esep.dao;


import kg.esep.models.ExchangeRate;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {

}
