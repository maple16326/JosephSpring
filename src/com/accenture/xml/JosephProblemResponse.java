package com.accenture.xml;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;


@XmlRootElement
public class JosephProblemResponse {
	private String people;
	@XmlElement
	public String getPeople() {
		return people;
	}

	public void setPeople(String people) {
		this.people = people;
	}
}
