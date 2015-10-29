package com.mulesoft.raml1.java.parser.impl.datamodel;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.datamodel.DateElement;
import com.mulesoft.raml1.java.parser.model.systemTypes.DateFormatSpec;
import com.mulesoft.raml1.java.parser.impl.systemTypes.DateFormatSpecImpl;



public class DateElementImpl extends DataElementImpl implements DateElement {

    public DateElementImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected DateElementImpl(){
        super();
    }


    @XmlElement(name="dateFormat")
    public DateFormatSpec dateFormat(){
        return super.getAttribute("dateFormat", DateFormatSpecImpl.class);
    }
}