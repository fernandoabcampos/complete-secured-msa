package com.msasecure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.msasecure.service.CardStatementIntegrationService;

/**
 * @author Fernando Antonio Barbeiro Campos
 * @mail: fernandoabcampos@gmail.com
 * @contact: github.com/fernandoabcampos
 * @since: 4 de feb. de 2016
 */

@RestController
@SuppressWarnings("rawtypes")
public class CardStatementController {

	@Autowired
	CardStatementIntegrationService integration;

	@RequestMapping("/only-cards")
	public ResponseEntity getOnlyCards(@RequestParam(value = "cardId", required = true) Long cardId) {
		return new CardStatementIntegrationService.Builder().withCardOrStatement(integration.getCard(cardId)).build();
	}

	@RequestMapping("/card-statements")
	public ResponseEntity getCardWithStatement(@RequestParam(value = "cardId", required = true) Long cardId) {
		return new CardStatementIntegrationService.Builder()
				.withCardOrStatement(integration.getStatementFromCard(cardId)).build();
	}

}
