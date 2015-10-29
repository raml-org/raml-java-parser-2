package com.mulesoft.raml1.java.parser.impl.methodsAndResources;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.Custom;



public class CustomImpl extends SecuritySchemaImpl implements Custom {

    public CustomImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected CustomImpl(){
        super();
    }



}