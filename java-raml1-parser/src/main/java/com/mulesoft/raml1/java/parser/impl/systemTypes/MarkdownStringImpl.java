package com.mulesoft.raml1.java.parser.impl.systemTypes;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.systemTypes.MarkdownString;



public class MarkdownStringImpl extends StringTypeImpl implements MarkdownString {

    public MarkdownStringImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected MarkdownStringImpl(){
        super();
    }



}