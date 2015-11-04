package com.mulesoft.raml1.java.parser.model.datamodel;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.IJavaElementNode;



public interface XMLInfo extends IJavaElementNode {

    @XmlElement(name="name")
    String name();


    @XmlElement(name="namespace")
    String namespace();


    @XmlElement(name="prefix")
    String prefix();


    @XmlElement(name="attribute")
    Boolean attribute();


    @XmlElement(name="wrapped")
    Boolean wrapped();

}