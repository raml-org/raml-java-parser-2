package com.mulesoft.raml1.java.parser.impl.methodsAndResources;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.impl.systemTypes.ReferenceImpl;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.ResourceTypeRef;



public class ResourceTypeRefImpl extends ReferenceImpl implements ResourceTypeRef {

    public ResourceTypeRefImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected ResourceTypeRefImpl(){
        super();
    }



}