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
@Table(name = "moneyBalance")
public class MoneyBalance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String currency;
    Integer amount;
    @JsonFormat(pattern = "dd.MM.yyyy hh:mm:ss")
    Date lastUpdated;

    @ManyToOne
    @JoinColumn(name = "balanceChange")
    CurrencyTransaction moneyTransaction;

}
