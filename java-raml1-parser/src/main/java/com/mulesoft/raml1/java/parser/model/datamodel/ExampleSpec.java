package com.mulesoft.raml1.java.parser.model.datamodel;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.model.common.RAMLLanguageElement;
import com.mulesoft.raml1.java.parser.model.systemTypes.MarkdownString;
import com.mulesoft.raml1.java.parser.model.declarations.AnnotationRef;



public interface ExampleSpec extends RAMLLanguageElement {

    @XmlElement(name="content")
    String content();


    @XmlElement(name="strict")
    Boolean strict();


    @XmlElement(name="name")
    String name();


    @XmlElement(name="displayName")
    String displayName();


    @XmlElement(name="description")
    MarkdownString description();


    @XmlElement(name="annotations")
    List<AnnotationRef> annotations();

}