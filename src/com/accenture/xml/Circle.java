package com.accenture.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;


public class Circle {

	private String[] peoples;

	private int interval;

	private int startNo;

	@XmlElementWrapper(name = "peoples")
	@XmlElement(name = "people")
	public String[] getPeoples() {
		return peoples;
	}

	public void setPeoples(String[] peoples) {

		this.peoples = peoples;

	}

	@XmlAttribute(name = "start")
	public int getStartNo() {
		return startNo;
	}

	public void setStartNo(int startNo) {

		this.startNo = startNo;

	}

	@XmlAttribute(name = "interval")
	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {

		this.interval = interval;

	}

}
