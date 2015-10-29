package com.mulesoft.raml1.java.parser.impl.systemTypes;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.systemTypes.StatusCode;



public class StatusCodeImpl extends StringTypeImpl implements StatusCode {

    public StatusCodeImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected StatusCodeImpl(){
        super();
    }



}