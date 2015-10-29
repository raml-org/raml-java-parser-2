package com.mulesoft.raml1.java.parser.impl.declarations;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.impl.systemTypes.ReferenceImpl;
import com.mulesoft.raml1.java.parser.model.declarations.AnnotationRef;



public class AnnotationRefImpl extends ReferenceImpl implements AnnotationRef {

    public AnnotationRefImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected AnnotationRefImpl(){
        super();
    }



}