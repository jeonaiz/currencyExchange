package kg.esep.dao;

import kg.esep.models.MoneyBalance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoneyBalanceRepository extends JpaRepository<MoneyBalance, Long> {
}
