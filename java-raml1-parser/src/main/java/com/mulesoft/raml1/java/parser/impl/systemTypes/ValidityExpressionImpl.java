package com.mulesoft.raml1.java.parser.impl.systemTypes;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.systemTypes.ValidityExpression;



public class ValidityExpressionImpl extends StringTypeImpl implements ValidityExpression {

    public ValidityExpressionImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected ValidityExpressionImpl(){
        super();
    }



}