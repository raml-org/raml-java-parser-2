package com.mulesoft.raml1.java.parser.impl.declarations;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.impl.systemTypes.ValueTypeImpl;
import com.mulesoft.raml1.java.parser.model.declarations.AnnotationTarget;



public class AnnotationTargetImpl extends ValueTypeImpl implements AnnotationTarget {

    public AnnotationTargetImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected AnnotationTargetImpl(){
        super();
    }



}