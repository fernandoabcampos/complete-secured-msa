package com.msasecure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ExtractApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExtractApplication.class, args);
	}
}
