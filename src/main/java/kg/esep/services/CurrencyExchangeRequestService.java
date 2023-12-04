package kg.esep.services;

import kg.esep.models.CurrencyExchangeRequestEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CurrencyExchangeRequestService {

    private final CurrencyExchangeResponseService responseService;
    public CurrencyExchangeRequestService(CurrencyExchangeResponseService responseService) {
        this.responseService = responseService;
    }

    @EventListener
    @Transactional
    public void handleCurrencyExchangeRequest(CurrencyExchangeRequestEvent event) {
        try {
            String senderUsername = Optional.ofNullable(event.getSenderUsername())
                    .orElseThrow(() -> new IllegalArgumentException("Sender username is required"));

            String targetUsername = Optional.ofNullable(event.getTargetUsername())
                    .orElseThrow(() -> new IllegalArgumentException("Target username is required"));

            String currencyCode = Optional.ofNullable(event.getCurrencyCode())
                    .orElseThrow(() -> new IllegalArgumentException("Currency code is required"));

            double amount = event.getAmount();

            boolean isApproved = true;
            responseService.sendResponse(senderUsername, targetUsername, currencyCode, amount, isApproved);
        } catch (Exception e) {

            System.err.println("Error handling currency exchange request: " + e.getMessage());
            throw new RuntimeException("Failed to process currency exchange request", e);
        }
    }
}
