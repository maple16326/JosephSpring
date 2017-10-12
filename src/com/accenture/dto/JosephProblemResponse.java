package com.accenture.dto;

import java.util.List;

import com.accenture.converter.annotation.JsonProperty;

public class JosephProblemResponse extends DataTransferObject {
	@JsonProperty(name = "person")
	private String person;

	private List<Error> errors;


	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

/*	public String getLastPerson() {
		return person;
	}

	public void setLastPerson(String person) {
		this.person = person;
	}*/

}
