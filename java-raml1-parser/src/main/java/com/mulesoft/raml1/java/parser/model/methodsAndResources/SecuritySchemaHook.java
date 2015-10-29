package com.mulesoft.raml1.java.parser.model.methodsAndResources;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.IJavaElementNode;
import com.mulesoft.raml1.java.parser.model.datamodel.DataElement;



public interface SecuritySchemaHook extends IJavaElementNode {

    @XmlElement(name="parameters")
    List<DataElement> parameters();


    @XmlElement(name="script")
    SecuritySchemaHookScript script();

}