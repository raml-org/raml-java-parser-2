package com.mulesoft.raml1.java.parser.model.methodsAndResources;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.model.systemTypes.FixedUri;
import com.mulesoft.raml1.java.parser.model.systemTypes.MarkdownString;
import com.mulesoft.raml1.java.parser.model.declarations.AnnotationRef;



public interface OAuth1SecuritySchemeSettings extends SecuritySchemaSettings {

    @XmlElement(name="requestTokenUri")
    FixedUri requestTokenUri();


    @XmlElement(name="authorizationUri")
    FixedUri authorizationUri();


    @XmlElement(name="tokenCredentialsUri")
    FixedUri tokenCredentialsUri();


    @XmlElement(name="signatures")
    List<String> signatures();


    @XmlElement(name="displayName")
    String displayName();


    @XmlElement(name="description")
    MarkdownString description();


    @XmlElement(name="annotations")
    List<AnnotationRef> annotations();


    @XmlElement(name="authentificationConfigurator")
    SecuritySchemaHook authentificationConfigurator();

}