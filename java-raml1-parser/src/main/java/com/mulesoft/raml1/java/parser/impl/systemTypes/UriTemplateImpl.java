package com.mulesoft.raml1.java.parser.impl.systemTypes;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.systemTypes.UriTemplate;



public class UriTemplateImpl extends StringTypeImpl implements UriTemplate {

    public UriTemplateImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected UriTemplateImpl(){
        super();
    }



}