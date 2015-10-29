package com.mulesoft.raml1.java.parser.impl.datamodel;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.datamodel.UnionField;



public class UnionFieldImpl extends DataElementImpl implements UnionField {

    public UnionFieldImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected UnionFieldImpl(){
        super();
    }


    @XmlElement(name="discriminator")
    public String discriminator(){
        return super.getAttribute("discriminator", String.class);
    }
}