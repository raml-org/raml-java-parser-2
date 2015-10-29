package com.mulesoft.raml1.java.parser.model.systemTypes;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.IJavaAttributeNode;



public interface ValueType extends IJavaAttributeNode {

    @XmlElement(name="undefined")
    String value();

}