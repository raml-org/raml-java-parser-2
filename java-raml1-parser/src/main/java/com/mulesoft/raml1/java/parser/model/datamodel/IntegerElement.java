package com.mulesoft.raml1.java.parser.model.datamodel;

import javax.xml.bind.annotation.XmlElement;



public interface IntegerElement extends NumberElement {

    @XmlElement(name="format")
    String format();

}