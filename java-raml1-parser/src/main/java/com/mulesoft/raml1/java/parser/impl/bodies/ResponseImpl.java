package com.mulesoft.raml1.java.parser.impl.bodies;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.impl.common.RAMLLanguageElementImpl;
import com.mulesoft.raml1.java.parser.model.bodies.Response;
import com.mulesoft.raml1.java.parser.model.systemTypes.StatusCode;
import com.mulesoft.raml1.java.parser.impl.systemTypes.StatusCodeImpl;
import com.mulesoft.raml1.java.parser.model.datamodel.DataElement;
import com.mulesoft.raml1.java.parser.impl.datamodel.DataElementImpl;
import com.mulesoft.raml1.java.parser.model.systemTypes.MarkdownString;
import com.mulesoft.raml1.java.parser.impl.systemTypes.MarkdownStringImpl;
import com.mulesoft.raml1.java.parser.model.declarations.AnnotationRef;
import com.mulesoft.raml1.java.parser.impl.declarations.AnnotationRefImpl;



public class ResponseImpl extends RAMLLanguageElementImpl implements Response {

    public ResponseImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected ResponseImpl(){
        super();
    }


    @XmlElement(name="code")
    public StatusCode code(){
        return super.getAttribute("code", StatusCodeImpl.class);
    }


    @XmlElement(name="headers")
    public List<DataElement> headers(){
        return super.getElements("headers", DataElementImpl.class);
    }


    @XmlElement(name="body")
    public List<DataElement> body(){
        return super.getElements("body", DataElementImpl.class);
    }


    @XmlElement(name="displayName")
    public String displayName(){
        return super.getAttribute("displayName", String.class);
    }


    @XmlElement(name="description")
    public MarkdownString description(){
        return super.getAttribute("description", MarkdownStringImpl.class);
    }


    @XmlElement(name="annotations")
    public List<AnnotationRef> annotations(){
        return super.getAttributes("annotations", AnnotationRefImpl.class);
    }
}