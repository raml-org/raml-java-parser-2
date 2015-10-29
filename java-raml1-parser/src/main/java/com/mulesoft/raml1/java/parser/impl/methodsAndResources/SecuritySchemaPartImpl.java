package com.mulesoft.raml1.java.parser.impl.methodsAndResources;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.SecuritySchemaPart;
import com.mulesoft.raml1.java.parser.model.datamodel.DataElement;
import com.mulesoft.raml1.java.parser.impl.datamodel.DataElementImpl;
import com.mulesoft.raml1.java.parser.model.bodies.Response;
import com.mulesoft.raml1.java.parser.impl.bodies.ResponseImpl;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.TraitRef;
import com.mulesoft.raml1.java.parser.impl.methodsAndResources.TraitRefImpl;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.SecuritySchemaRef;
import com.mulesoft.raml1.java.parser.impl.methodsAndResources.SecuritySchemaRefImpl;



public class SecuritySchemaPartImpl extends MethodBaseImpl implements SecuritySchemaPart {

    public SecuritySchemaPartImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected SecuritySchemaPartImpl(){
        super();
    }


    @XmlElement(name="headers")
    public List<DataElement> headers(){
        return super.getElements("headers", DataElementImpl.class);
    }


    @XmlElement(name="queryParameters")
    public List<DataElement> queryParameters(){
        return super.getElements("queryParameters", DataElementImpl.class);
    }


    @XmlElement(name="queryString")
    public DataElement queryString(){
        return super.getElement("queryString", DataElementImpl.class);
    }


    @XmlElement(name="responses")
    public List<Response> responses(){
        return super.getElements("responses", ResponseImpl.class);
    }


    @XmlElement(name="is")
    public List<TraitRef> is(){
        return super.getAttributes("is", TraitRefImpl.class);
    }


    @XmlElement(name="securedBy")
    public List<SecuritySchemaRef> securedBy(){
        return super.getAttributes("securedBy", SecuritySchemaRefImpl.class);
    }
}