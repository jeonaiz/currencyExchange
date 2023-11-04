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
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String surname;
    String phoneNumber;
    String email;
    Long position_id;
    @JsonFormat(pattern = "dd.MM.yyyy hh:mm:ss")
    Date addDate;

    @ManyToOne
    @JoinColumn(name = "relatedUserID")
    MoneyTransaction moneyTransaction;

    @ManyToOne
    @JoinColumn(name = "userID")
    CurrencyExchange currencyExchange;
}

