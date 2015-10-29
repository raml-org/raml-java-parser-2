package com.mulesoft.raml1.java.parser.model.api;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.model.common.RAMLLanguageElement;



public interface ScriptSpec extends RAMLLanguageElement {

    @XmlElement(name="language")
    String language();


    @XmlElement(name="content")
    String content();

}