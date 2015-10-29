package com.mulesoft.raml1.java.parser.model.methodsAndResources;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.model.common.RAMLLanguageElement;
import com.mulesoft.raml1.java.parser.model.datamodel.DataElement;



public interface ResourceBase extends RAMLLanguageElement {

    @XmlElement(name="methods")
    List<Method> methods();


    @XmlElement(name="is")
    List<TraitRef> is();


    @XmlElement(name="type")
    ResourceTypeRef type();


    @XmlElement(name="securedBy")
    List<SecuritySchemaRef> securedBy();


    @XmlElement(name="uriParameters")
    List<DataElement> uriParameters();

}