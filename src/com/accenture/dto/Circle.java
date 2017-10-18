package com.accenture.dto;

import java.util.List;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

import com.accenture.validator.annotation.ListSizeLimitation;
import com.accenture.validator.annotation.NoRepetitionList;


public class Circle extends DataTransferObject {
	@NotNull(message = "{value.illegal.null}")
	@Min(value=0,message = "{start.illegal.minValue}")
	//@ListSizeLimitation(listFieldName="start", limitedFieldName = "persons")
	private Integer start;

	@NotNull(message = "{value.illegal.null}")
	@Min(value=1,message = "{interval.illegal.minValue}")
	//@ListSizeLimitation(listFieldName="interval", limitedFieldName = "persons")
	private Integer interval;

	@NotEmpty(message = "{value.illegal.empty}")
	@NoRepetitionList
	//@ListSizeLimitation(listFieldName="start", limitedFieldName = "persons")
	//@ListSizeLimitation(listFieldName="interval", limitedFieldName = "persons")
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
