package kg.esep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"models"})

public class EsepApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsepApplication.class, args);
	}

}
