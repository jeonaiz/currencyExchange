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
    Integer balanceChange;
    Integer relatedUserId;


    @JsonFormat(pattern = "dd.MM.yyyy hh:mm:ss")
    Date transactionDate;
}
