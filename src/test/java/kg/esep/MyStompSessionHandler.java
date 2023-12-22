package kg.esep;


import java.lang.reflect.Type;

import org.springframework.messaging.Message;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;


public class MyStompSessionHandler implements StompSessionHandler
{
    @Override
    public void afterConnected( final StompSession session, final StompHeaders connectedHeaders )
    {
        session.subscribe("/topic/messages", this);
        session.send("/app/chat", getSampleMessage());
    }


    private Object getSampleMessage()
    {
        return "Hello!";
    }


    @Override
    public void handleException( final StompSession session, final StompCommand command, final StompHeaders headers,
                                 final byte[] payload, final Throwable exception )
    {

    }


    @Override
    public void handleTransportError( final StompSession session, final Throwable exception )
    {

    }


    @Override
    public Type getPayloadType( final StompHeaders headers )
    {
        return null;
    }


    @Override
    public void handleFrame( final StompHeaders headers, final Object payload )
    {
        Message msg = ( Message ) payload;
//        logger.info("Received : " + msg.getText()+ " from : " + msg.getFrom());
    }
}
