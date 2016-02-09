package com.msasecure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableResourceServer
public class CardStatementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardStatementApiApplication.class, args);
	}
}
