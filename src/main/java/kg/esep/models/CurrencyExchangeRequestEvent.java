package kg.esep.models;

import org.springframework.context.ApplicationEvent;

public class CurrencyExchangeRequestEvent extends ApplicationEvent {

    private final String senderUsername;
    private final String targetUsername;
    private final String currencyCode;

    public String getSenderUsername() {
        return senderUsername;
    }

    public String getTargetUsername() {
        return targetUsername;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public double getAmount() {
        return amount;
    }

    private final double amount;

    public CurrencyExchangeRequestEvent(Object source, String senderUsername, String targetUsername, String currencyCode, double amount) {
        super(source);
        this.senderUsername = senderUsername;
        this.targetUsername = targetUsername;
        this.currencyCode = currencyCode;
        this.amount = amount;
    }

}
