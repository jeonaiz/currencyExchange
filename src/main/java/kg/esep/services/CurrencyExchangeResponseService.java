package kg.esep.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

@EnableWebSocketMessageBroker
@Service
public class CurrencyExchangeResponseService {
 private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public CurrencyExchangeResponseService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void sendResponse(String senderUsername, String targetUsername, String currencyCode, double amount, boolean isApproved) {
        if (isApproved) {
            System.out.println("Request approved. Sending response to user " + senderUsername);

            sendNotification(senderUsername, "Your request has been approved");
        } else {
            System.out.println("Request declined. Sending response to user" + senderUsername);

            sendNotification(senderUsername, "Your request has been declined");
        }
    }

    private void sendNotification(String username, String message) {
        messagingTemplate.convertAndSendToUser(username, "/queue/notifications", message);
    }
}
