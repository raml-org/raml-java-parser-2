package com.mulesoft.raml1.java.parser.model.datamodel;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.model.common.RAMLLanguageElement;
import com.mulesoft.raml1.java.parser.model.systemTypes.MarkdownString;
import com.mulesoft.raml1.java.parser.model.declarations.AnnotationRef;



public interface DataElement extends RAMLLanguageElement {

    @XmlElement(name="name")
    String name();


    @XmlElement(name="facets")
    List<DataElement> facets();


    @XmlElement(name="schema")
    String schema();


    @XmlElement(name="usage")
    String usage();


    @XmlElement(name="type")
    List<String> type();


    @XmlElement(name="location")
    ModelLocation location();


    @XmlElement(name="locationKind")
    LocationKind locationKind();


    @XmlElement(name="default")
    String default_();


    @XmlElement(name="example")
    String example();


    @XmlElement(name="examples")
    List<ExampleSpec> examples();


    @XmlElement(name="repeat")
    Boolean repeat();


    @XmlElement(name="required")
    Boolean required();


    @XmlElement(name="displayName")
    String displayName();


    @XmlElement(name="description")
    MarkdownString description();


    @XmlElement(name="annotations")
    List<AnnotationRef> annotations();

}