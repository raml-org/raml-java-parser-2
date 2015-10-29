package com.mulesoft.raml1.java.parser.model.datamodel;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.model.systemTypes.DateFormatSpec;



public interface DateElement extends DataElement {

    @XmlElement(name="dateFormat")
    DateFormatSpec dateFormat();

}