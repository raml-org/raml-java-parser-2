package com.mulesoft.raml1.java.parser.model.datamodel;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;



public interface NumberElement extends DataElement {

    @XmlElement(name="minimum")
    Double minimum();


    @XmlElement(name="maximum")
    Double maximum();


    @XmlElement(name="enum")
    List<String> enum_();


    @XmlElement(name="format")
    String format();


    @XmlElement(name="multipleOf")
    Double multipleOf();

}