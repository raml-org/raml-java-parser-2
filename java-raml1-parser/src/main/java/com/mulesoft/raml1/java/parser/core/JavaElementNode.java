package com.mulesoft.raml1.java.parser.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import org.apache.commons.lang3.StringEscapeUtils;

public class JavaElementNode implements IJavaElementNode {

	public JavaElementNode(Object jsNode, JavaNodeFactory factory) {
		this.jsNode = jsNode;
		this.factory = factory;
	}

	protected JavaElementNode() {
	}

	private Object jsNode;

	private JavaNodeFactory factory;

	protected <T, S extends T> T getAttribute(String name, Class<S> clazz) {
		return this.factory.getAttribute(this.jsNode, name, clazz);
	}

	protected <T, S extends T> List<T> getAttributes(String name, Class<S> clazz) {
		return this.factory.getAttributes(this.jsNode, name, clazz);
	}

	protected <T, S extends T> T getElement(String name, Class<S> clazz) {
		return this.factory.getElement(this.jsNode, name, clazz);
	}

	public <T, S extends T> List<T> getElements(String name, Class<S> clazz) {
		return this.factory.getElements(this.jsNode, name, clazz);
	}

	public List<ValidationIssue> getErrors() {
		return this.factory.getErrors(this.jsNode);
	}

	public String toJSON() {
		return toJSON(0);
	}

	public String toJSON(int offset) {

		String indent = "";
		for (int i = 0; i < offset; i++) {
			indent += " ";
		}
		String bodyIndent = indent + "    ";
		String arrayIndent = indent + "        ";
		StringBuilder bld = new StringBuilder("{");
		for (Method m : this.getClass().getMethods()) {
			XmlElement prop = m.getAnnotation(XmlElement.class);
			if (prop == null) {
				continue;
			}
			String propName = prop.name();
			Class<?> returnType = m.getReturnType();

			try {
				Object value = m.invoke(this);
				if (value != null) {
					if (returnType == List.class) {
						String str = m.getGenericReturnType().getTypeName();
						String qName = str.substring(str.indexOf("<") + 1, str.lastIndexOf(">"));
						returnType = this.getClass().getClassLoader().loadClass(qName);
						boolean isElement = IJavaNode.class.isAssignableFrom(returnType);
						List<?> lst = (List<?>) value;
						if (lst.size() > 0) {
							bld.append("\n").append(bodyIndent).append("\"").append(propName).append("\" : [");
							for (Object component : lst) {
								if (isElement) {
									String elementStr = ((IJavaNode) component).toJSON(offset + 8);
									bld.append(" " + (elementStr != null ? elementStr.trim() : "NULL"));
									bld.append(",");
								} else {
									String valStr = prepareStringValue(component);
									bld.append("\n").append(arrayIndent).append(valStr).append(",");
								}

							}
							if (lst.size() > 0) {
								bld.setCharAt(bld.length() - 1, '\n');
								bld.append(bodyIndent);
							}
							bld.append("],");
						}
					} else {
						boolean isElement = IJavaNode.class.isAssignableFrom(returnType);
						bld.append("\n").append(bodyIndent).append("\"").append(propName).append("\" : ");
						if (isElement) {
							String elementStr = ((IJavaNode) value).toJSON(offset + 4);
							bld.append(elementStr);
						} else {
							String valStr = prepareStringValue(value);
							bld.append(valStr.toString());
						}
						bld.append(",");
					}
				}

			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (bld.length() > 1) {
			bld.setCharAt(bld.length() - 1, '\n');
		}
		bld.append(indent + "}");
		return bld.toString();

	}

	private String prepareStringValue(Object component) {
		boolean isString = component.getClass() == String.class;
		String valStr = component.toString();
		if (valStr.indexOf('"') >= 0) {
			valStr = StringEscapeUtils.escapeEcmaScript(valStr);
		}
		if (isString) {
			valStr = "\"" + valStr + "\"";
		}
		return valStr;
	}

}
