package kg.esep.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import kg.esep.client.SocketHandler;


@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer
{
    public void registerWebSocketHandlers( WebSocketHandlerRegistry registry )
    {
        registry.addHandler( new SocketHandler(), "/ws" ).setAllowedOrigins( "*" );
    }
}