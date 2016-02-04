package com.msasecure.service;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.msasecure.model.Card;
import com.msasecure.model.CardStatement;
import com.msasecure.model.Statement;

/**
 * @author Fernando Antonio Barbeiro Campos
 * @param <T>
 * @mail: fernandoabcampos@gmail.com
 * @contact: github.com/fernandoabcampos
 * @since: 4 de feb. de 2016
 */
@Component
public class CardStatementIntegrationService {

	public static final class Builder {

		@SuppressWarnings("rawtypes")
		private ResponseEntity object = null;

		public <T> Builder withCardOrStatement(final T response) {
			object = new ResponseEntity<>(response, HttpStatus.OK);
			return this;
		}

		@SuppressWarnings("rawtypes")
		public ResponseEntity build() {
			return object;
		}
	}

	private RestTemplate rest = new RestTemplate();
	ObjectMapper mapper = new ObjectMapper();

	@Value("${card.endpoint}")
	private String cardEndpoint;

	@Value("${extract.endpoint}")
	private String extractEndpoint;

	public Card getCard(Long cardId) {

		String url = cardEndpoint + "cards/" + cardId;

		ResponseEntity<String> cardStr = rest.getForEntity(url, String.class);

		Card card = null;
		try {
			card = mapper.readValue(cardStr.getBody(), Card.class);
		} catch (IOException e) {
			e.printStackTrace();
			// FIXME: shame on me
		}

		return card;
	}

	public CardStatement getStatementFromCard(Long cardId) {

		String url = extractEndpoint + "statement?cardId=" + cardId;

		ResponseEntity<String> statementStr = rest.getForEntity(url, String.class);

		Collection<Statement> stms = null;
		try {
			stms = mapper.readValue(statementStr.getBody(), new TypeReference<List<Statement>>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
			// FIXME: shame on me 2
		}

		Card card = getCard(cardId);

		CardStatement cardStm = new CardStatement(card, stms);

		return cardStm;

	}

}
