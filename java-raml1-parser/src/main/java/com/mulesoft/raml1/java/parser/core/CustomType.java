package com.mulesoft.raml1.java.parser.core;

import javax.xml.bind.JAXBException;
import javax.xml.bind.PropertyException;
import javax.xml.bind.annotation.XmlElement;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorNode;

@XmlDiscriminatorNode("__$$type__")
public class CustomType implements IJavaNode {

	private CustomTypeRegistry registry;

	private String valueName;

	public String toJSON() {

		try {
			return this.registry.marshalCustomType(this);
		} catch (PropertyException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String toJSON(int offset) {

		String str = this.toJSON();
		if (str == null) {
			return null;
		}
		String indent = "";
		for (int i = 0; i < offset; i++) {
			indent += ' ';
		}
		return str.replace("\n", "\n" + indent);
	}

	public void setFactory(CustomTypeRegistry registry) {
		this.registry = registry;
	}

	@XmlElement(name = "RAML-value-name")
	public String getRAMLValueName() {
		return valueName;
	}

	void setRAMLValueName(String valueName) {
		this.valueName = valueName;
	}

}
