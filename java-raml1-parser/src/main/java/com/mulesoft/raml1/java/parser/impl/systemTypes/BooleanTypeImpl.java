package com.mulesoft.raml1.java.parser.impl.systemTypes;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.systemTypes.BooleanType;



public class BooleanTypeImpl extends ValueTypeImpl implements BooleanType {

    public BooleanTypeImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected BooleanTypeImpl(){
        super();
    }



}