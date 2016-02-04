package com.msasecure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.msasecure.model.Card;
import com.msasecure.repository.CardRepository;

/**
 * @author Fernando Antonio Barbeiro Campos
 * @mail: fernandoabcampos@gmail.com
 * @contact: github.com/fernandoabcampos
 * @since: 3 de feb. de 2016
 */

@RestController
public class CardController {
	@Autowired
	CardRepository cardRepo;

	@RequestMapping("/cardz/{cardId}")
	public Card getCard(@PathVariable Long cardId) {
		return cardRepo.findOne(cardId);
	}

	@RequestMapping(path = "/new-card", method = RequestMethod.POST)
	public void createCard(@RequestBody Card newCard) {
		cardRepo.save(newCard);
		System.out.println("New card passing: " + newCard);
	}

}