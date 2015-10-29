package com.mulesoft.raml1.java.parser.model.datamodel;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.model.systemTypes.RAMLSelector;



public interface RAMLPointerElement extends DataElement {

    @XmlElement(name="target")
    RAMLSelector target();

}