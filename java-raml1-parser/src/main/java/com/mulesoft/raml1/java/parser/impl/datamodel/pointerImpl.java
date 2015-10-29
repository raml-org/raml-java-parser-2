package com.mulesoft.raml1.java.parser.impl.datamodel;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.impl.systemTypes.ValueTypeImpl;
import com.mulesoft.raml1.java.parser.model.datamodel.pointer;



public class pointerImpl extends ValueTypeImpl implements pointer {

    public pointerImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected pointerImpl(){
        super();
    }



}