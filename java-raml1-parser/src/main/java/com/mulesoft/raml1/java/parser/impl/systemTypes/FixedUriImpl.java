package com.mulesoft.raml1.java.parser.impl.systemTypes;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.systemTypes.FixedUri;



public class FixedUriImpl extends StringTypeImpl implements FixedUri {

    public FixedUriImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected FixedUriImpl(){
        super();
    }



}