package com.mulesoft.raml1.java.parser.impl.datamodel;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.datamodel.ArrayField;



public class ArrayFieldImpl extends DataElementImpl implements ArrayField {

    public ArrayFieldImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected ArrayFieldImpl(){
        super();
    }


    @XmlElement(name="uniqueItems")
    public Boolean uniqueItems(){
        return super.getAttribute("uniqueItems", Boolean.class);
    }


    @XmlElement(name="minItems")
    public Double minItems(){
        return super.getAttribute("minItems", Double.class);
    }


    @XmlElement(name="maxItems")
    public Double maxItems(){
        return super.getAttribute("maxItems", Double.class);
    }
}