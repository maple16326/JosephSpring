package com.accenture.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.accenture.validator.annotation.ListSizeLimitation;
import com.accenture.validator.annotation.NoRepetitionList;


public class JosephProblemRequest extends DataTransferObject {

@NotNull(message="{circle.not.empty}")  
@ListSizeLimitation(listFieldName="circle.start", limitedFieldName = "circle.persons")
@ListSizeLimitation(listFieldName="circle.interval", limitedFieldName = "circle.persons")
@Valid
	private Circle circle;

public Circle getCircle() {
	return circle;
}

public void setCircle(Circle circle) {
	this.circle = circle;
}

}
