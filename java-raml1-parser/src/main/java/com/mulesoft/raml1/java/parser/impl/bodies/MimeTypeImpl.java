package com.mulesoft.raml1.java.parser.impl.bodies;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.impl.systemTypes.StringTypeImpl;
import com.mulesoft.raml1.java.parser.model.bodies.MimeType;



public class MimeTypeImpl extends StringTypeImpl implements MimeType {

    public MimeTypeImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected MimeTypeImpl(){
        super();
    }



}