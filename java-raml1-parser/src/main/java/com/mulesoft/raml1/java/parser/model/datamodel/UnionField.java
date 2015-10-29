package com.mulesoft.raml1.java.parser.model.datamodel;

import javax.xml.bind.annotation.XmlElement;



public interface UnionField extends DataElement {

    @XmlElement(name="discriminator")
    String discriminator();

}