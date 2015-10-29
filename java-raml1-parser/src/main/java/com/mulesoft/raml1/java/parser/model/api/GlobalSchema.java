package com.mulesoft.raml1.java.parser.model.api;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.model.common.RAMLSimpleElement;
import com.mulesoft.raml1.java.parser.model.systemTypes.SchemaString;



public interface GlobalSchema extends RAMLSimpleElement {

    @XmlElement(name="key")
    String key();


    @XmlElement(name="value")
    SchemaString value();

}