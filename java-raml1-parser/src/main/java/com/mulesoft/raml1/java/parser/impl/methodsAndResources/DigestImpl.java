package com.mulesoft.raml1.java.parser.impl.methodsAndResources;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.Digest;



public class DigestImpl extends SecuritySchemaImpl implements Digest {

    public DigestImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected DigestImpl(){
        super();
    }



}