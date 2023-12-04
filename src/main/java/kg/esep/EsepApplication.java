package kg.esep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;


@SpringBootApplication
@EnableConfigurationProperties
@EnableWebSocketMessageBroker
@EnableWebSocket

@EntityScan(basePackages = { "kg.esep.models" })

public class EsepApplication
{

	public static void main(String[] args) {
		SpringApplication.run( EsepApplication.class, args );
	}

}
