package models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name = "currencyExchange")
public class CurrencyExchange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSourceCurrency() {
        return sourceCurrency;
    }

    public void setSourceCurrency(String sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public Integer getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Integer exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getProfit() {
        return profit;
    }

    public void setProfit(Integer profit) {
        this.profit = profit;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    String sourceCurrency;
    String targetCurrency;
    Integer exchangeRate;
    Integer amount;
    Integer profit;
    @JsonFormat(pattern = "dd.MM.yyyy hh:mm:ss")
    Date transactionDate;

}
