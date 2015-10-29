package com.mulesoft.raml1.java.parser.model.methodsAndResources;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.model.common.RAMLLanguageElement;



public interface SecuritySchemaSettings extends RAMLLanguageElement {

    @XmlElement(name="authentificationConfigurator")
    SecuritySchemaHook authentificationConfigurator();

}