package com.mulesoft.raml1.java.parser.impl.methodsAndResources;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.Method;
import com.mulesoft.raml1.java.parser.model.systemTypes.SchemaString;
import com.mulesoft.raml1.java.parser.impl.systemTypes.SchemaStringImpl;
import com.mulesoft.raml1.java.parser.model.systemTypes.MarkdownString;
import com.mulesoft.raml1.java.parser.impl.systemTypes.MarkdownStringImpl;
import com.mulesoft.raml1.java.parser.model.datamodel.DataElement;
import com.mulesoft.raml1.java.parser.impl.datamodel.DataElementImpl;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.TraitRef;
import com.mulesoft.raml1.java.parser.impl.methodsAndResources.TraitRefImpl;
import com.mulesoft.raml1.java.parser.model.declarations.AnnotationRef;
import com.mulesoft.raml1.java.parser.impl.declarations.AnnotationRefImpl;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.SecuritySchemaRef;
import com.mulesoft.raml1.java.parser.impl.methodsAndResources.SecuritySchemaRefImpl;



public class MethodImpl extends MethodBaseImpl implements Method {

    public MethodImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected MethodImpl(){
        super();
    }


    @XmlElement(name="signature")
    public SchemaString signature(){
        return super.getAttribute("signature", SchemaStringImpl.class);
    }


    @XmlElement(name="method")
    public String method(){
        return super.getAttribute("method", String.class);
    }


    @XmlElement(name="displayName")
    public String displayName(){
        return super.getAttribute("displayName", String.class);
    }


    @XmlElement(name="description")
    public MarkdownString description(){
        return super.getAttribute("description", MarkdownStringImpl.class);
    }


    @XmlElement(name="queryString")
    public DataElement queryString(){
        return super.getElement("queryString", DataElementImpl.class);
    }


    @XmlElement(name="queryParameters")
    public List<DataElement> queryParameters(){
        return super.getElements("queryParameters", DataElementImpl.class);
    }


    @XmlElement(name="headers")
    public List<DataElement> headers(){
        return super.getElements("headers", DataElementImpl.class);
    }


    @XmlElement(name="body")
    public List<DataElement> body(){
        return super.getElements("body", DataElementImpl.class);
    }


    @XmlElement(name="is")
    public List<TraitRef> is(){
        return super.getAttributes("is", TraitRefImpl.class);
    }


    @XmlElement(name="annotations")
    public List<AnnotationRef> annotations(){
        return super.getAttributes("annotations", AnnotationRefImpl.class);
    }


    @XmlElement(name="securedBy")
    public List<SecuritySchemaRef> securedBy(){
        return super.getAttributes("securedBy", SecuritySchemaRefImpl.class);
    }
}