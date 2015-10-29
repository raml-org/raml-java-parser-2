package com.mulesoft.raml1.java.parser.impl.systemTypes;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.core.JavaAttributeNode;
import com.mulesoft.raml1.java.parser.model.systemTypes.Reference;
import com.mulesoft.raml1.java.parser.core.CustomType;



public class ReferenceImpl extends JavaAttributeNode implements Reference {

    public ReferenceImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected ReferenceImpl(){
        super();
    }


    @XmlElement(name="value")
    public CustomType value(){
        return super.customClassValue();
    }
}