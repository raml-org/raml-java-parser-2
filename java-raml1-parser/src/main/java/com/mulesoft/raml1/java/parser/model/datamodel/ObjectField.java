package com.mulesoft.raml1.java.parser.model.datamodel;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;



public interface ObjectField extends DataElement {

    @XmlElement(name="properties")
    List<DataElement> properties();


    @XmlElement(name="minProperties")
    Double minProperties();


    @XmlElement(name="maxProperties")
    Double maxProperties();


    @XmlElement(name="additionalProperties")
    DataElement additionalProperties();


    @XmlElement(name="patternProperties")
    List<DataElement> patternProperties();


    @XmlElement(name="discriminator")
    pointer discriminator();


    @XmlElement(name="discriminatorValue")
    String discriminatorValue();


    @XmlElement(name="facets")
    List<DataElement> facets();

}