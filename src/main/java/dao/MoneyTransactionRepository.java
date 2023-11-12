package dao;

import models.MoneyTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoneyTransactionRepository extends JpaRepository<MoneyTransaction, Long> {
}
