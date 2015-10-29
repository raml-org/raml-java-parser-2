package com.mulesoft.raml1.java.parser.impl.datamodel;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.datamodel.ValueElement;



public class ValueElementImpl extends DataElementImpl implements ValueElement {

    public ValueElementImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected ValueElementImpl(){
        super();
    }



}