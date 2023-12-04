package kg.esep.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "profit")
public class Profit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    private CurrencyTransaction transaction;
    @ManyToOne
    @JoinColumn(name = "profit_id")
    private CurrencyExchange currencyExchange;

    @Column(name = "profit_value")
    private double profitValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CurrencyTransaction getTransaction() {
        return transaction;
    }

    public void setTransaction(CurrencyTransaction transaction) {
        this.transaction = transaction;
    }

    public CurrencyExchange getCurrencyExchange() {
        return currencyExchange;
    }

    public void setCurrencyExchange(CurrencyExchange currencyExchange) {
        this.currencyExchange = currencyExchange;
    }

    public double getProfitValue() {
        return profitValue;
    }

    public void setProfitValue(double profitValue) {
        this.profitValue = profitValue;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }

    @Column(name = "transaction_time")
    private LocalDateTime transactionTime;


}

