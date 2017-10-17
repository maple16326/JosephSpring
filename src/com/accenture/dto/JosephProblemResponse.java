package com.accenture.dto;

import java.util.List;


public class JosephProblemResponse extends DataTransferObject {
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

	
}
