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
@Table(name = "moneyTransaction")
public class MoneyTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Integer getBalanceChange() {
        return balanceChange;
    }

    public void setBalanceChange(Integer balanceChange) {
        this.balanceChange = balanceChange;
    }

    public Integer getRelatedUserId() {
        return relatedUserId;
    }

    public void setRelatedUserId(Integer relatedUserId) {
        this.relatedUserId = relatedUserId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    String currency;
    String transactionType;
    Integer balanceChange;
    Integer relatedUserId;


    @JsonFormat(pattern = "dd.MM.yyyy hh:mm:ss")
    Date transactionDate;
}
