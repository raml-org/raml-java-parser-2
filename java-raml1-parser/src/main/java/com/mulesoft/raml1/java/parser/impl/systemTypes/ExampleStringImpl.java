package com.mulesoft.raml1.java.parser.impl.systemTypes;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.systemTypes.ExampleString;



public class ExampleStringImpl extends StringTypeImpl implements ExampleString {

    public ExampleStringImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected ExampleStringImpl(){
        super();
    }



}