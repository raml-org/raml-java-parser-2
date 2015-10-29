package com.mulesoft.raml1.java.parser.model.methodsAndResources;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.model.datamodel.DataElement;
import com.mulesoft.raml1.java.parser.model.bodies.Response;



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

}