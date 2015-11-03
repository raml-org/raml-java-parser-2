package com.mulesoft.raml1.java.parser.model.methodsAndResources;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.model.systemTypes.FixedUri;



public interface OAuth2SecuritySchemeSettings extends SecuritySchemaSettings {

    @XmlElement(name="accessTokenUri")
    FixedUri accessTokenUri();


    @XmlElement(name="authorizationUri")
    FixedUri authorizationUri();


    @XmlElement(name="authorizationGrants")
    List<String> authorizationGrants();


    @XmlElement(name="scopes")
    List<String> scopes();

}