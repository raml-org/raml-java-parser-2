package com.mulesoft.raml1.java.parser.model.parameters;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.model.common.RAMLLanguageElement;
import com.mulesoft.raml1.java.parser.model.datamodel.DataElement;



public interface HasNormalParameters extends RAMLLanguageElement {

    @XmlElement(name="queryParameters")
    List<DataElement> queryParameters();


    @XmlElement(name="headers")
    List<DataElement> headers();


    @XmlElement(name="queryString")
    DataElement queryString();

}