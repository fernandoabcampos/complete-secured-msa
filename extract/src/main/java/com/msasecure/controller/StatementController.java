package com.msasecure.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.msasecure.model.Statement;
import com.msasecure.model.Statement.StatementType;

/**
 * @author Fernando Antonio Barbeiro Campos
 * @mail: fernandoabcampos@gmail.com
 * @contact: github.com/fernandoabcampos
 * @since: 4 de feb. de 2016
 */

@RestController
public class StatementController {

	@RequestMapping("/statement")
	public Collection<Statement> getStatements(@RequestParam(value = "cardId", required = true) Long cardId) {
		Long x = new Random().nextLong();
		return Arrays.asList(
				new Statement(cardId, x, (x / 2 == 0 ? StatementType.CREDIT : StatementType.DEBIT),
						LocalDate.now().toString()),
				new Statement(cardId, (x + 1), ((x + 1) / 2 == 0 ? StatementType.CREDIT : StatementType.DEBIT),
						LocalDate.now().toString()));
	}

}
