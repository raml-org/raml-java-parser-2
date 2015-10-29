package com.mulesoft.raml1.java.parser.impl.methodsAndResources;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.impl.parameters.HasNormalParametersImpl;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.MethodBase;
import com.mulesoft.raml1.java.parser.model.bodies.Response;
import com.mulesoft.raml1.java.parser.impl.bodies.ResponseImpl;
import com.mulesoft.raml1.java.parser.model.datamodel.DataElement;
import com.mulesoft.raml1.java.parser.impl.datamodel.DataElementImpl;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.TraitRef;
import com.mulesoft.raml1.java.parser.impl.methodsAndResources.TraitRefImpl;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.SecuritySchemaRef;
import com.mulesoft.raml1.java.parser.impl.methodsAndResources.SecuritySchemaRefImpl;



public class MethodBaseImpl extends HasNormalParametersImpl implements MethodBase {

    public MethodBaseImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected MethodBaseImpl(){
        super();
    }


    @XmlElement(name="responses")
    public List<Response> responses(){
        return super.getElements("responses", ResponseImpl.class);
    }


    @XmlElement(name="body")
    public List<DataElement> body(){
        return super.getElements("body", DataElementImpl.class);
    }


    @XmlElement(name="protocols")
    public List<String> protocols(){
        return super.getAttributes("protocols", String.class);
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