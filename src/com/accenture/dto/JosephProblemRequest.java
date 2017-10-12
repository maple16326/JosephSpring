package com.accenture.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.accenture.converter.annotation.JsonProperty;

public class JosephProblemRequest extends DataTransferObject {
@JsonProperty(name = "circle")
@NotNull(message="{circle.not.empty}")  
@Valid
	private Circle circle;

public Circle getCircle() {
	return circle;
}

public void setCircle(Circle circle) {
	this.circle = circle;
}

}
