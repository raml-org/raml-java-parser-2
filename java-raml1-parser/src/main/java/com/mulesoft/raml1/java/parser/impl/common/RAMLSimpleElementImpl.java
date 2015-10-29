package com.mulesoft.raml1.java.parser.impl.common;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.core.JavaElementNode;
import com.mulesoft.raml1.java.parser.model.common.RAMLSimpleElement;



public class RAMLSimpleElementImpl extends JavaElementNode implements RAMLSimpleElement {

    public RAMLSimpleElementImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected RAMLSimpleElementImpl(){
        super();
    }



}