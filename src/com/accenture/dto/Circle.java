package com.accenture.dto;

import java.util.List;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;


public class Circle extends DataTransferObject {
	@NotNull(message = "start cannot be null")
	@Min(value=0,message = "start should be greater than or equal to 0")
	private Integer start;

	@NotNull(message = "interval cannot be null")
	@Min(value=1,message = "interval should be greater than or equal to 1")
	private Integer interval;

	@NotEmpty(message = "persons cannot be null")
	private List<String> persons;

	public List<String> getPersons() {
		return persons;
	}

	public void setPersons(List<String> persons) {
		this.persons = persons;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getInterval() {
		return interval;
	}

	public void setInterval(Integer interval) {
		this.interval = interval;
	}

	

}
