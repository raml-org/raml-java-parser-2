package com.mulesoft.raml1.java.parser.impl.methodsAndResources;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.impl.systemTypes.ReferenceImpl;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.SecuritySchemaRef;



public class SecuritySchemaRefImpl extends ReferenceImpl implements SecuritySchemaRef {

    public SecuritySchemaRefImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected SecuritySchemaRefImpl(){
        super();
    }



}