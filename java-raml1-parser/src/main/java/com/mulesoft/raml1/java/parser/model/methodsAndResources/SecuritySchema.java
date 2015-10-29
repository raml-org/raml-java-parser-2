package com.mulesoft.raml1.java.parser.model.methodsAndResources;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.model.common.RAMLLanguageElement;
import com.mulesoft.raml1.java.parser.model.systemTypes.MarkdownString;



public interface SecuritySchema extends RAMLLanguageElement {

    @XmlElement(name="name")
    String name();


    @XmlElement(name="type")
    String type();


    @XmlElement(name="description")
    MarkdownString description();


    @XmlElement(name="describedBy")
    SecuritySchemaPart describedBy();


    @XmlElement(name="settings")
    SecuritySchemaSettings settings();

}