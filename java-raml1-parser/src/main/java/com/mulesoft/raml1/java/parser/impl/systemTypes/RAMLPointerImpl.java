package com.mulesoft.raml1.java.parser.impl.systemTypes;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.systemTypes.RAMLPointer;



public class RAMLPointerImpl extends StringTypeImpl implements RAMLPointer {

    public RAMLPointerImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected RAMLPointerImpl(){
        super();
    }



}