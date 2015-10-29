package com.mulesoft.raml1.java.parser.model.methodsAndResources;

import javax.xml.bind.annotation.XmlElement;



public interface APIKeySettings extends SecuritySchemaSettings {

    @XmlElement(name="queryParameterName")
    String queryParameterName();


    @XmlElement(name="headerName")
    String headerName();

}