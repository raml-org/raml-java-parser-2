package com.mulesoft.raml1.java.parser.impl.systemTypes;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.systemTypes.FullUriTemplate;



public class FullUriTemplateImpl extends UriTemplateImpl implements FullUriTemplate {

    public FullUriTemplateImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected FullUriTemplateImpl(){
        super();
    }



}