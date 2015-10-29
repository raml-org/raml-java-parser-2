package com.mulesoft.raml1.java.parser.model.datamodel;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;



public interface StrElement extends DataElement {

    @XmlElement(name="pattern")
    String pattern();


    @XmlElement(name="minLength")
    Double minLength();


    @XmlElement(name="maxLength")
    Double maxLength();


    @XmlElement(name="enum")
    List<String> enum_();

}