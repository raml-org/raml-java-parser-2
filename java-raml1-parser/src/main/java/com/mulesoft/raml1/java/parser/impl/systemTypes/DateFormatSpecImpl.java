package com.mulesoft.raml1.java.parser.impl.systemTypes;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.systemTypes.DateFormatSpec;



public class DateFormatSpecImpl extends StringTypeImpl implements DateFormatSpec {

    public DateFormatSpecImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected DateFormatSpecImpl(){
        super();
    }



}