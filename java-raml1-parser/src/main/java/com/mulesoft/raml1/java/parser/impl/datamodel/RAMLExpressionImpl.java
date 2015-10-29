package com.mulesoft.raml1.java.parser.impl.datamodel;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.datamodel.RAMLExpression;



public class RAMLExpressionImpl extends DataElementImpl implements RAMLExpression {

    public RAMLExpressionImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected RAMLExpressionImpl(){
        super();
    }



}