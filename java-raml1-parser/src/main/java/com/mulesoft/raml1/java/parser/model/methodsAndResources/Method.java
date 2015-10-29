package com.mulesoft.raml1.java.parser.model.methodsAndResources;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.model.systemTypes.SchemaString;
import com.mulesoft.raml1.java.parser.model.systemTypes.MarkdownString;
import com.mulesoft.raml1.java.parser.model.datamodel.DataElement;
import com.mulesoft.raml1.java.parser.model.declarations.AnnotationRef;



public interface Method extends MethodBase {

    @XmlElement(name="signature")
    SchemaString signature();


    @XmlElement(name="method")
    String method();


    @XmlElement(name="displayName")
    String displayName();


    @XmlElement(name="description")
    MarkdownString description();


    @XmlElement(name="queryString")
    DataElement queryString();


    @XmlElement(name="queryParameters")
    List<DataElement> queryParameters();


    @XmlElement(name="headers")
    List<DataElement> headers();


    @XmlElement(name="body")
    List<DataElement> body();


    @XmlElement(name="is")
    List<TraitRef> is();


    @XmlElement(name="annotations")
    List<AnnotationRef> annotations();


    @XmlElement(name="securedBy")
    List<SecuritySchemaRef> securedBy();

}