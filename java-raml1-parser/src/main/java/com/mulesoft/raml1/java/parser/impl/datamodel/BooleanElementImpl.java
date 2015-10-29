package com.mulesoft.raml1.java.parser.impl.datamodel;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.datamodel.BooleanElement;



public class BooleanElementImpl extends DataElementImpl implements BooleanElement {

    public BooleanElementImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected BooleanElementImpl(){
        super();
    }



}