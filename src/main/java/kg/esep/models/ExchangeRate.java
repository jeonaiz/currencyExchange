package kg.esep.models;


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

    public Integer getBuyingRate() {
        return buyingRate;
    }

    public void setBuyingRate(Integer buyingRate) {
        this.buyingRate = buyingRate;
    }

    public Integer getSellingRate() {
        return sellingRate;
    }

    public void setSellingRate(Integer sellingRate) {
        this.sellingRate = sellingRate;
    }

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
