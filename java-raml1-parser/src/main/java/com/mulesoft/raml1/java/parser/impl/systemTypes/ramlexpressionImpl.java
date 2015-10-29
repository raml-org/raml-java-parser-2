package com.mulesoft.raml1.java.parser.impl.systemTypes;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.systemTypes.ramlexpression;



public class ramlexpressionImpl extends ValueTypeImpl implements ramlexpression {

    public ramlexpressionImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected ramlexpressionImpl(){
        super();
    }



}