package com.mulesoft.raml1.java.parser.model.api;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.model.systemTypes.FullUriTemplate;
import com.mulesoft.raml1.java.parser.model.datamodel.DataElement;
import com.mulesoft.raml1.java.parser.model.bodies.MimeType;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.SecuritySchemaRef;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.Resource;
import com.mulesoft.raml1.java.parser.model.systemTypes.MarkdownString;
import com.mulesoft.raml1.java.parser.model.declarations.AnnotationRef;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.SecuritySchemaType;



public interface Api extends Library {

    @XmlElement(name="title")
    String title();


    @XmlElement(name="version")
    String version();


    @XmlElement(name="baseUri")
    FullUriTemplate baseUri();


    @XmlElement(name="baseUriParameters")
    List<DataElement> baseUriParameters();


    @XmlElement(name="protocols")
    List<String> protocols();


    @XmlElement(name="mediaType")
    MimeType mediaType();


    @XmlElement(name="securedBy")
    List<SecuritySchemaRef> securedBy();


    @XmlElement(name="resources")
    List<Resource> resources();


    @XmlElement(name="documentation")
    List<DocumentationItem> documentation();


    @XmlElement(name="displayName")
    String displayName();


    @XmlElement(name="name")
    String name();


    @XmlElement(name="description")
    MarkdownString description();


    @XmlElement(name="annotations")
    List<AnnotationRef> annotations();


    @XmlElement(name="securitySchemaTypes")
    List<SecuritySchemaType> securitySchemaTypes();

}