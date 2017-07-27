package org.opendaylight.messenger.impl;

import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Elements {

	@XmlElement
	private Element [] elements = null;

	public List<Element> getElements() {
		return Arrays.asList(elements);
	}

	public Elements setElements(Element [] elements) {
		this.elements = elements;
		return this;
	}

}
