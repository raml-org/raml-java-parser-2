package com.mulesoft.raml1.java.parser.impl.systemTypes;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.core.JavaAttributeNode;
import com.mulesoft.raml1.java.parser.model.systemTypes.ValueType;



public class ValueTypeImpl extends JavaAttributeNode implements ValueType {

    public ValueTypeImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected ValueTypeImpl(){
        super();
    }


    @XmlElement(name="value")
    public String value(){
        return super.attributeValue();
    }
}