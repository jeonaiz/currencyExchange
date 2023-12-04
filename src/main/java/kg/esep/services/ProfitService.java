package kg.esep.services;

import kg.esep.utils.ProfitCalculator;
import kg.esep.dao.ProfitRepository;
import kg.esep.models.CurrencyTransaction;
import kg.esep.models.Profit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProfitService {

    private final ProfitRepository profitRepository;

    @Autowired
    public ProfitService(ProfitRepository profitRepository) {
        this.profitRepository = profitRepository;
    }

    public double calculateAndSaveProfit(CurrencyTransaction transaction) {
        double profit = ProfitCalculator.calculateProfit(transaction );

        Profit profitEntity = new Profit();
        profitEntity.setTransaction(transaction);
        profitEntity.setProfitValue(profit);
        profitRepository.save(profitEntity);

        return profit;
    }
}
