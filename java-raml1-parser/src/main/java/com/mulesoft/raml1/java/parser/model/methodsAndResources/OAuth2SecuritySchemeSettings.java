package com.mulesoft.raml1.java.parser.model.methodsAndResources;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.model.systemTypes.FixedUri;
import com.mulesoft.raml1.java.parser.model.systemTypes.MarkdownString;
import com.mulesoft.raml1.java.parser.model.declarations.AnnotationRef;



public interface OAuth2SecuritySchemeSettings extends SecuritySchemaSettings {

    @XmlElement(name="accessTokenUri")
    FixedUri accessTokenUri();


    @XmlElement(name="authorizationUri")
    FixedUri authorizationUri();


    @XmlElement(name="authorizationGrants")
    List<String> authorizationGrants();


    @XmlElement(name="scopes")
    List<String> scopes();


    @XmlElement(name="displayName")
    String displayName();


    @XmlElement(name="description")
    MarkdownString description();


    @XmlElement(name="annotations")
    List<AnnotationRef> annotations();


    @XmlElement(name="authentificationConfigurator")
    SecuritySchemaHook authentificationConfigurator();

}