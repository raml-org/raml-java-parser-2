package com.mulesoft.raml1.java.parser.impl.api;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.impl.common.RAMLLanguageElementImpl;
import com.mulesoft.raml1.java.parser.model.api.DocumentationItem;
import com.mulesoft.raml1.java.parser.model.systemTypes.MarkdownString;
import com.mulesoft.raml1.java.parser.impl.systemTypes.MarkdownStringImpl;



public class DocumentationItemImpl extends RAMLLanguageElementImpl implements DocumentationItem {

    public DocumentationItemImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected DocumentationItemImpl(){
        super();
    }


    @XmlElement(name="title")
    public String title(){
        return super.getAttribute("title", String.class);
    }


    @XmlElement(name="content")
    public MarkdownString content(){
        return super.getAttribute("content", MarkdownStringImpl.class);
    }
}