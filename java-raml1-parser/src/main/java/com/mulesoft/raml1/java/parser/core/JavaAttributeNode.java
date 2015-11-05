package com.mulesoft.raml1.java.parser.core;

import org.apache.commons.lang3.StringEscapeUtils;

import com.mulesoft.raml1.java.parser.model.systemTypes.ValueType;

public class JavaAttributeNode implements IJavaAttributeNode {

	protected JavaAttributeNode(Object jsNode, JavaNodeFactory factory) {
		this.jsNode = jsNode;
		this.factory = factory;
	}

	public JavaAttributeNode() {
	}

	private Object jsNode;

	private JavaNodeFactory factory;

	protected String attributeValue() {
		return this.factory.attributeValue(this.jsNode);
	}

	protected CustomType customClassValue() {
		return this.factory.customClassValue(this.jsNode);
	}

	public String toJSON() {
		return this.toJSON(0);
	}

	public String toJSON(int offset) {
		if (this instanceof ValueType) {
			return "\"" + StringEscapeUtils.escapeEcmaScript(this.attributeValue()) + "\"";
		}
		return this.customClassValue().toJSON(offset);
	}

}
