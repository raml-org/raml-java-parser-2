package com.mulesoft.raml1.java.parser.model.api;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.model.common.RAMLSimpleElement;



public interface ImportDeclaration extends RAMLSimpleElement {

    @XmlElement(name="key")
    String key();


    @XmlElement(name="value")
    Library value();

}