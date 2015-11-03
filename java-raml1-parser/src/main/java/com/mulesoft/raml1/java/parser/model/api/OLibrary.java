package com.mulesoft.raml1.java.parser.model.api;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.model.common.RAMLLanguageElement;
import com.mulesoft.raml1.java.parser.model.datamodel.DataElement;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.Trait;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.ResourceType;
import com.mulesoft.raml1.java.parser.model.declarations.AnnotationType;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.SecuritySchemaType;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.SecuritySchema;



public interface OLibrary extends RAMLLanguageElement {

    @XmlElement(name="name")
    String name();


    @XmlElement(name="schemas")
    List<GlobalSchema> schemas();


    @XmlElement(name="types")
    List<DataElement> types();


    @XmlElement(name="traits")
    List<Trait> traits();


    @XmlElement(name="resourceTypes")
    List<ResourceType> resourceTypes();


    @XmlElement(name="annotationTypes")
    List<AnnotationType> annotationTypes();


    @XmlElement(name="securitySchemaTypes")
    List<SecuritySchemaType> securitySchemaTypes();


    @XmlElement(name="securitySchemes")
    List<SecuritySchema> securitySchemes();


    @XmlElement(name="uses")
    List<Library> uses();

}