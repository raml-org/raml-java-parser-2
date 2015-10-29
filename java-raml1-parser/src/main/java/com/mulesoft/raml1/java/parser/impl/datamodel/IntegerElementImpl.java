package com.mulesoft.raml1.java.parser.impl.datamodel;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.datamodel.IntegerElement;



public class IntegerElementImpl extends NumberElementImpl implements IntegerElement {

    public IntegerElementImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected IntegerElementImpl(){
        super();
    }


    @XmlElement(name="format")
    public String format(){
        return super.getAttribute("format", String.class);
    }
}