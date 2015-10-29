package com.mulesoft.raml1.java.parser.model.methodsAndResources;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.model.common.RAMLLanguageElement;
import com.mulesoft.raml1.java.parser.model.datamodel.DataElement;



public interface SecuritySchemaType extends RAMLLanguageElement {

    @XmlElement(name="requiredSettings")
    List<DataElement> requiredSettings();


    @XmlElement(name="describedBy")
    SecuritySchemaPart describedBy();

}