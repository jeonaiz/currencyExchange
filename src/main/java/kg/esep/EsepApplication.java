package com.example.currencyexchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;


@SpringBootApplication
@EnableConfigurationProperties
@EnableWebSocketMessageBroker
@EnableWebSocket
@EntityScan(basePackages = {"models"})

public class EsepApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsepApplication.class, args);
	}

}
