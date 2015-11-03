package com.mulesoft.raml1.java.parser.impl.api;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.api.Api;
import com.mulesoft.raml1.java.parser.model.systemTypes.FullUriTemplate;
import com.mulesoft.raml1.java.parser.impl.systemTypes.FullUriTemplateImpl;
import com.mulesoft.raml1.java.parser.model.datamodel.DataElement;
import com.mulesoft.raml1.java.parser.impl.datamodel.DataElementImpl;
import com.mulesoft.raml1.java.parser.model.bodies.MimeType;
import com.mulesoft.raml1.java.parser.impl.bodies.MimeTypeImpl;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.SecuritySchemaRef;
import com.mulesoft.raml1.java.parser.impl.methodsAndResources.SecuritySchemaRefImpl;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.Resource;
import com.mulesoft.raml1.java.parser.impl.methodsAndResources.ResourceImpl;
import com.mulesoft.raml1.java.parser.model.api.DocumentationItem;
import com.mulesoft.raml1.java.parser.impl.api.DocumentationItemImpl;
import com.mulesoft.raml1.java.parser.model.systemTypes.MarkdownString;
import com.mulesoft.raml1.java.parser.impl.systemTypes.MarkdownStringImpl;
import com.mulesoft.raml1.java.parser.model.declarations.AnnotationRef;
import com.mulesoft.raml1.java.parser.impl.declarations.AnnotationRefImpl;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.SecuritySchemaType;
import com.mulesoft.raml1.java.parser.impl.methodsAndResources.SecuritySchemaTypeImpl;



public class ApiImpl extends OLibraryImpl implements Api {

    public ApiImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected ApiImpl(){
        super();
    }


    @XmlElement(name="title")
    public String title(){
        return super.getAttribute("title", String.class);
    }


    @XmlElement(name="version")
    public String version(){
        return super.getAttribute("version", String.class);
    }


    @XmlElement(name="baseUri")
    public FullUriTemplate baseUri(){
        return super.getAttribute("baseUri", FullUriTemplateImpl.class);
    }


    @XmlElement(name="baseUriParameters")
    public List<DataElement> baseUriParameters(){
        return super.getElements("baseUriParameters", DataElementImpl.class);
    }


    @XmlElement(name="protocols")
    public List<String> protocols(){
        return super.getAttributes("protocols", String.class);
    }


    @XmlElement(name="mediaType")
    public MimeType mediaType(){
        return super.getAttribute("mediaType", MimeTypeImpl.class);
    }


    @XmlElement(name="securedBy")
    public List<SecuritySchemaRef> securedBy(){
        return super.getAttributes("securedBy", SecuritySchemaRefImpl.class);
    }


    @XmlElement(name="resources")
    public List<Resource> resources(){
        return super.getElements("resources", ResourceImpl.class);
    }


    @XmlElement(name="documentation")
    public List<DocumentationItem> documentation(){
        return super.getElements("documentation", DocumentationItemImpl.class);
    }


    @XmlElement(name="displayName")
    public String displayName(){
        return super.getAttribute("displayName", String.class);
    }


    @XmlElement(name="name")
    public String name(){
        return super.getAttribute("name", String.class);
    }


    @XmlElement(name="description")
    public MarkdownString description(){
        return super.getAttribute("description", MarkdownStringImpl.class);
    }


    @XmlElement(name="annotations")
    public List<AnnotationRef> annotations(){
        return super.getAttributes("annotations", AnnotationRefImpl.class);
    }


    @XmlElement(name="securitySchemaTypes")
    public List<SecuritySchemaType> securitySchemaTypes(){
        return super.getElements("securitySchemaTypes", SecuritySchemaTypeImpl.class);
    }
}