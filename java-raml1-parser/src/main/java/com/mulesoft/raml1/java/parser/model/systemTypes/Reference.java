package com.mulesoft.raml1.java.parser.model.systemTypes;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.IJavaAttributeNode;
import com.mulesoft.raml1.java.parser.core.CustomType;



public interface Reference extends IJavaAttributeNode {

    @XmlElement(name="undefined")
    CustomType value();

}