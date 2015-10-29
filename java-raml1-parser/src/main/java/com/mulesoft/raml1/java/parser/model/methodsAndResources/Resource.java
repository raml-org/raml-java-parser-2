package com.mulesoft.raml1.java.parser.model.methodsAndResources;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.model.systemTypes.SchemaString;
import com.mulesoft.raml1.java.parser.model.systemTypes.RelativeUri;
import com.mulesoft.raml1.java.parser.model.systemTypes.MarkdownString;
import com.mulesoft.raml1.java.parser.model.declarations.AnnotationRef;



public interface Resource extends ResourceBase {

    @XmlElement(name="signature")
    SchemaString signature();


    @XmlElement(name="relativeUri")
    RelativeUri relativeUri();


    @XmlElement(name="resources")
    List<Resource> resources();


    @XmlElement(name="displayName")
    String displayName();


    @XmlElement(name="description")
    MarkdownString description();


    @XmlElement(name="annotations")
    List<AnnotationRef> annotations();

}