package com.mulesoft.raml1.java.parser.model.methodsAndResources;

import javax.xml.bind.annotation.XmlElement;



public interface APIKey extends SecuritySchema {

    @XmlElement(name="settings")
    APIKeySettings settings();

}