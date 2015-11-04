package com.mulesoft.raml1.java.parser.model.methodsAndResources;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.model.datamodel.DataElement;
import com.mulesoft.raml1.java.parser.model.bodies.Response;
import com.mulesoft.raml1.java.parser.model.systemTypes.MarkdownString;
import com.mulesoft.raml1.java.parser.model.declarations.AnnotationRef;



public interface SecuritySchemaPart extends MethodBase {

    @XmlElement(name="headers")
    List<DataElement> headers();


    @XmlElement(name="queryParameters")
    List<DataElement> queryParameters();


    @XmlElement(name="queryString")
    DataElement queryString();


    @XmlElement(name="responses")
    List<Response> responses();


    @XmlElement(name="is")
    List<TraitRef> is();


    @XmlElement(name="securedBy")
    List<SecuritySchemaRef> securedBy();


    @XmlElement(name="displayName")
    String displayName();


    @XmlElement(name="description")
    MarkdownString description();


    @XmlElement(name="annotations")
    List<AnnotationRef> annotations();

}