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

    String currency;
    String transactionType;
    Long balanceChange;

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

    public Long getBalanceChange() {
        return balanceChange;
    }

    public void setBalanceChange(Long balanceChange) {
        this.balanceChange = balanceChange;
    }

    public Long getRelatedUserId() {
        return relatedUserId;
    }

    public void setRelatedUserId(Long relatedUserId) {
        this.relatedUserId = relatedUserId;
    }

    Long relatedUserId;

    @JsonFormat(pattern = "dd.MM.yyyy hh:mm:ss")
    Date transactionDate;
}
