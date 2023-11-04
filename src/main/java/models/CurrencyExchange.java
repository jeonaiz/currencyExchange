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

    String sourceCurrency;
    String targetCurrency;
    Integer exchangeRate;
    Integer amount;
    Integer profit;
    @JsonFormat(pattern = "dd.MM.yyyy hh:mm:ss")
    Date transactionDate;

}
