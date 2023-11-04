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
@Table(name = "exchangeRate")
public class ExchangeRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String currency;
    Integer buyingRate;
    Integer sellingRate;

    @JsonFormat(pattern = "dd.MM.yyyy hh:mm:ss")
    Date effectiveDate;

    @ManyToOne
    @JoinColumn(name = "exchangeRates")
    CurrencyExchange currencyExchange;

}
