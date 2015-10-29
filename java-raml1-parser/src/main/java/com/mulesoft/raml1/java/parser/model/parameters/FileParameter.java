package com.mulesoft.raml1.java.parser.model.parameters;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.model.datamodel.DataElement;
import com.mulesoft.raml1.java.parser.model.systemTypes.ContentType;



public interface FileParameter extends DataElement {

    @XmlElement(name="fileTypes")
    List<ContentType> fileTypes();


    @XmlElement(name="minLength")
    Double minLength();


    @XmlElement(name="maxLength")
    Double maxLength();

}