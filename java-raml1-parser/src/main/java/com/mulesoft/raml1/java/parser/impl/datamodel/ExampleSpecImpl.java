package com.mulesoft.raml1.java.parser.impl.datamodel;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.impl.common.RAMLLanguageElementImpl;
import com.mulesoft.raml1.java.parser.model.datamodel.ExampleSpec;
import com.mulesoft.raml1.java.parser.model.systemTypes.MarkdownString;
import com.mulesoft.raml1.java.parser.impl.systemTypes.MarkdownStringImpl;
import com.mulesoft.raml1.java.parser.model.declarations.AnnotationRef;
import com.mulesoft.raml1.java.parser.impl.declarations.AnnotationRefImpl;



public class ExampleSpecImpl extends RAMLLanguageElementImpl implements ExampleSpec {

    public ExampleSpecImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected ExampleSpecImpl(){
        super();
    }


    @XmlElement(name="content")
    public String content(){
        return super.getAttribute("content", String.class);
    }


    @XmlElement(name="strict")
    public Boolean strict(){
        return super.getAttribute("strict", Boolean.class);
    }


    @XmlElement(name="name")
    public String name(){
        return super.getAttribute("name", String.class);
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