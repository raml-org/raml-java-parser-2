package com.mulesoft.raml1.java.parser.model.methodsAndResources;

import javax.xml.bind.annotation.XmlElement;



public interface Oath1 extends SecuritySchema {

    @XmlElement(name="settings")
    OAuth1SecuritySchemeSettings settings();

}