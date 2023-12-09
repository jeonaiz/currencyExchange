package kg.esep.utils;

import kg.esep.enums.TransactionType;
import kg.esep.models.CurrencyTransaction;

public class ProfitCalculator {

    public static double calculateProfit(CurrencyTransaction transaction) {
        if (transaction == null) {
            throw new IllegalArgumentException("Transaction cannot be null");
        }

        double amount = transaction.getAmount();
        double purchaseAmount = transaction.getPurchaseAmount();
        double exchangeRate = transaction.getExchangeRate();
        TransactionType transactionType = transaction.getTransactionType();

        if (transactionType == TransactionType.BUY) {
            return 0.0;
        } else if (transactionType == TransactionType.SELL) {
            return (amount * exchangeRate) - (purchaseAmount*amount);
        }

        throw new IllegalArgumentException("Invalid transaction type");
    }
}
