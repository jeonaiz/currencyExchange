package dao;

import models.Profit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfitRepository extends JpaRepository<Profit, Long> {
}
