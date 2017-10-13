package com.accenture.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
public class FibonacciSequenceRequest {
	private long length;

	@XmlElement
	public long getLength() {
		return length;
	}

	public void setLength(long length) {

		this.length = length;

	}

}
