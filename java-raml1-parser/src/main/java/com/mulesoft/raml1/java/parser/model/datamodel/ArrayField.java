package com.mulesoft.raml1.java.parser.model.datamodel;

import javax.xml.bind.annotation.XmlElement;



public interface ArrayField extends DataElement {

    @XmlElement(name="uniqueItems")
    Boolean uniqueItems();


    @XmlElement(name="items")
    DataElement items();


    @XmlElement(name="minItems")
    Double minItems();


    @XmlElement(name="maxItems")
    Double maxItems();

}