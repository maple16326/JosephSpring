package com.accenture.xml;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElementWrapper;
@XmlRootElement
public class FibonacciSequenceResponse {

	private List<Long>values;

	
	@XmlElementWrapper(name = "sequence")
	@XmlElement(name = "value")
	public List<Long> getValues() {
		return values;
	}
	public void setValues(List<Long> values) {
		this.values = values;
	}

}
