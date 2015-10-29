package com.mulesoft.raml1.java.parser.model.api;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.model.common.RAMLLanguageElement;



public interface ApiDescription extends RAMLLanguageElement {

    @XmlElement(name="apiFiles")
    List<Api> apiFiles();


    @XmlElement(name="script")
    List<ScriptSpec> script();


    @XmlElement(name="type")
    String type();

}