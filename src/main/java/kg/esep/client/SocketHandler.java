package kg.esep.client;


import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kg.esep.models.dto.EsepEvent;
import kg.esep.models.dto.ExchangeRequestDto;
import kg.esep.utils.DtoUtil;


@Component
public class SocketHandler extends TextWebSocketHandler
{
    private final static Logger log = LogManager.getLogger( SocketHandler.class );

    List sessions = new CopyOnWriteArrayList<>();


    @Override
    public void handleTextMessage( WebSocketSession session, TextMessage message )
            throws InterruptedException, IOException
    {
        String strMessage = message.getPayload();
        EsepEvent event = DtoUtil.toEvent( strMessage );

        log.info( strMessage );

        //  {"type":"EXCHANGE","m":"{\"source\":\"USD\",\"target\":\"KGS\",\"rate\":86.6,\"side\":\"SELL\"}"}
        switch ( event.getType() )
        {
            case EXCHANGE:
                handleExchange( event.getMessage() );
                break;
            case AUTH:
                break;
        }

//        EsepEvent event1 = new EsepEvent();
//        event1.setType( EXCHANGE );
//
//        ExchangeRequestDto requestDto = new ExchangeRequestDto();
//        requestDto.setRate( 86.6 );
//        requestDto.setSide( ExchangeRequestDto.Side.SELL );
//        requestDto.setSourceCurrency( ExchangeRequestDto.Currency.USD );
//        requestDto.setTargetCurrency( ExchangeRequestDto.Currency.KGS );
//        event1.setMessage( DtoUtil.toString( requestDto ) );

//        log.info( DtoUtil.toString( event1 ) );
//                log.info( message.getPayload() );
         session.sendMessage( new TextMessage( "Hello from backend!" ) );
    }


    private void handleExchange( final String message )
    {
        ExchangeRequestDto dto = DtoUtil.toExchangeRequestDto( message );
        log.info( dto );
    }


    @Override
    public void afterConnectionEstablished( WebSocketSession session ) throws Exception
    {
        //the messages will be broadcasted to all users.
        sessions.add( session );
    }
}