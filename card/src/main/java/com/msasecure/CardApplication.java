package com.msasecure;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.msasecure.controller.CardController;
import com.msasecure.model.Card;

/**
 * @author Fernando Antonio Barbeiro Campos
 * @mail: fernandoabcampos@gmail.com
 * @contact: github.com/fernandoabcampos
 * @since: 3 de feb. de 2016
 */

@SpringBootApplication
@EnableDiscoveryClient
public class CardApplication {

	@Bean
	CommandLineRunner runner(CardController cardService) {

		int end = 11, start = 0;
		Integer year = new Random().nextInt(2025 - Year.now().getValue());

		Card c = new Card(new BigInteger(130, new SecureRandom()).toString(32),
				String.valueOf(Math.random()).substring(0, 16),
				YearMonth.of(year, Month.of(new Random().nextInt(end - start))).toString()
				);
		
		cardService.createCard(c);

		return null;

	}

	public static void main(String[] args) {
		SpringApplication.run(CardApplication.class, args);
	}
}
