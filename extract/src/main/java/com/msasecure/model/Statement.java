package com.msasecure.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Fernando Antonio Barbeiro Campos
 * @mail: fernandoabcampos@gmail.com
 * @contact: github.com/fernandoabcampos
 * @since: 4 de feb. de 2016
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Statement {

	private Long cardId;
	private Long statementId;
	private StatementType type;
	private String date;

	public enum StatementType {
		CREDIT, DEBIT
	}

	public Statement() {
		super();
	}

	public Statement(Long cardId, Long statementId, StatementType type, String date) {
		super();
		this.cardId = cardId;
		this.statementId = statementId;
		this.type = type;
		this.date = date;
	}

	public Long getCardId() {
		return cardId;
	}

	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}

	public Long getStatementId() {
		return statementId;
	}

	public void setStatementId(Long statementId) {
		this.statementId = statementId;
	}

	public StatementType getType() {
		return type;
	}

	public void setType(StatementType type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Statement [cardId=" + cardId + ", statementId=" + statementId + ", type=" + type + ", date=" + date
				+ "]";
	}

}
