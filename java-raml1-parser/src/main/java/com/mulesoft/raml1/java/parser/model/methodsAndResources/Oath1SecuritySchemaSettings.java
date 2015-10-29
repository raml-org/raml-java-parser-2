package com.mulesoft.raml1.java.parser.model.methodsAndResources;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.model.systemTypes.FixedUri;



public interface Oath1SecuritySchemaSettings extends SecuritySchemaSettings {

    @XmlElement(name="requestTokenUri")
    FixedUri requestTokenUri();


    @XmlElement(name="authorizationUri")
    FixedUri authorizationUri();


    @XmlElement(name="tokenCredentialsUri")
    FixedUri tokenCredentialsUri();


    @XmlElement(name="signatures")
    List<String> signatures();

}