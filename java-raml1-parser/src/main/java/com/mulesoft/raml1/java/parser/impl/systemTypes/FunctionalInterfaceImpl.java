package com.mulesoft.raml1.java.parser.impl.systemTypes;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.systemTypes.FunctionalInterface;



public class FunctionalInterfaceImpl extends StringTypeImpl implements FunctionalInterface {

    public FunctionalInterfaceImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected FunctionalInterfaceImpl(){
        super();
    }



}