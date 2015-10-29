package com.mulesoft.raml1.java.parser.model.common;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.IJavaElementNode;
import com.mulesoft.raml1.java.parser.model.systemTypes.MarkdownString;
import com.mulesoft.raml1.java.parser.model.declarations.AnnotationRef;



public interface RAMLLanguageElement extends IJavaElementNode {

    @XmlElement(name="displayName")
    String displayName();


    @XmlElement(name="description")
    MarkdownString description();


    @XmlElement(name="annotations")
    List<AnnotationRef> annotations();

}