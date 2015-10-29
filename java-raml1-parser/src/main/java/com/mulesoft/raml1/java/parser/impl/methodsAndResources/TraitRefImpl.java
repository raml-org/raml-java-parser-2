package com.mulesoft.raml1.java.parser.impl.methodsAndResources;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.impl.systemTypes.ReferenceImpl;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.TraitRef;



public class TraitRefImpl extends ReferenceImpl implements TraitRef {

    public TraitRefImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected TraitRefImpl(){
        super();
    }



}