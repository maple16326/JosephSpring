package com.accenture.xml;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient; 
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name="josephProblemRequest")
public class JosephProblemRequest {
	
	private Circle circle;
	
	@XmlElement(name = "circle")
	public Circle getCircle() {
		return circle;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
	}

}
