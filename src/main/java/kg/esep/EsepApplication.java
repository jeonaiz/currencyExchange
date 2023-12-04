package kg.esep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableConfigurationProperties
//@EnableWebSocketMessageBroker
//@EnableWebSocket
@ComponentScan
@EntityScan(basePackages = { "kg.esep.models" })

public class EsepApplication
{

	public static void main(String[] args) {
		SpringApplication.run( EsepApplication.class, args );
	}

}
