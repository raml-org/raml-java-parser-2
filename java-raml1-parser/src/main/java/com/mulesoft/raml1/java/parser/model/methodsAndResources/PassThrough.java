package com.mulesoft.raml1.java.parser.model.methodsAndResources;

import javax.xml.bind.annotation.XmlElement;



public interface PassThrough extends SecuritySchema {

    @XmlElement(name="settings")
    PassThroughSettings settings();

}