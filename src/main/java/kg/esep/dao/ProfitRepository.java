package kg.esep.dao;

import kg.esep.models.Profit;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ProfitRepository extends JpaRepository<Profit, Long> {
}
