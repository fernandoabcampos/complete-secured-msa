package com.msasecure.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Fernando Antonio Barbeiro Campos
 * @mail: fernandoabcampos@gmail.com
 * @contact: github.com/fernandoabcampos
 * @since: 3 de feb. de 2016
 */

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Card {
	@Id
	@GeneratedValue
	private Long id;
	private String cardHolderName;
	private String pan;
	private String validDate;

	public Card() {
		super();
	}

	public Card(String cardHolderName, String pan, String validDate) {
		super();
		this.cardHolderName = cardHolderName;
		this.pan = pan;
		this.validDate = validDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getValidDate() {
		return validDate;
	}

	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", cardHolderName=" + cardHolderName + ", pan=" + pan + ", validDate=" + validDate
				+ "]";
	}

}
