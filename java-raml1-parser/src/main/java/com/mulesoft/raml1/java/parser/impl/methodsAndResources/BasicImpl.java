package com.mulesoft.raml1.java.parser.impl.methodsAndResources;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.Basic;



public class BasicImpl extends SecuritySchemaImpl implements Basic {

    public BasicImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected BasicImpl(){
        super();
    }



}