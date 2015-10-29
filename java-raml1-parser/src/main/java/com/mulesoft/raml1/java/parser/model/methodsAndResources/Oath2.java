package com.mulesoft.raml1.java.parser.model.methodsAndResources;

import javax.xml.bind.annotation.XmlElement;



public interface Oath2 extends SecuritySchema {

    @XmlElement(name="settings")
    OAuth2SecuritySchemeSettings settings();

}