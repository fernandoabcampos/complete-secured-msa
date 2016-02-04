package com.msasecure.model;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Fernando Antonio Barbeiro Campos
 * @mail: fernandoabcampos@gmail.com
 * @contact: github.com/fernandoabcampos
 * @since: 4 de feb. de 2016
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CardStatement {

	private Card card;
	private Collection<Statement> statements;
	private String version = "1";

	public CardStatement() {
		super();
	}

	public CardStatement(Card card, Collection<Statement> statements) {
		super();
		this.card = card;
		this.statements = statements;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public Collection<Statement> getStatements() {
		return statements;
	}

	public void setStatements(Collection<Statement> statements) {
		this.statements = statements;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "CardStatement [card=" + card + ", statements=" + statements + "]";
	}

}
