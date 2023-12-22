package kg.esep.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kg.esep.client.SocketHandler;
import kg.esep.models.dto.EsepEvent;
import kg.esep.models.dto.ExchangeRequestDto;


public class DtoUtil
{
    private final static Logger log = LogManager.getLogger( SocketHandler.class );
    public static final ObjectMapper OM = new ObjectMapper();


    public static EsepEvent toEvent( String message )
    {
        try
        {
            return OM.readValue( message, EsepEvent.class );
        }
        catch ( JsonProcessingException e )
        {
            log.error( e.getMessage(), e );
            return null;
        }
    }


    public static ExchangeRequestDto toExchangeRequestDto( String message )
    {
        try
        {
            return OM.readValue( message, ExchangeRequestDto.class );
        }
        catch ( JsonProcessingException e )
        {
            log.error( e.getMessage(), e );
            return null;
        }
    }


    public static String toString( final ExchangeRequestDto requestDto )
    {
        try
        {
            return OM.writeValueAsString( requestDto );
        }
        catch ( JsonProcessingException e )
        {
            log.error( e.getMessage(), e );
            return null;
        }
    }


    public static String toString( final EsepEvent requestDto )
    {
        try
        {
            return OM.writeValueAsString( requestDto );
        }
        catch ( JsonProcessingException e )
        {
            log.error( e.getMessage(), e );
            return null;
        }
    }
}
