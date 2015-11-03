package com.mulesoft.raml1.java.parser.impl.api;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.impl.common.RAMLLanguageElementImpl;
import com.mulesoft.raml1.java.parser.model.api.OLibrary;
import com.mulesoft.raml1.java.parser.model.api.GlobalSchema;
import com.mulesoft.raml1.java.parser.impl.api.GlobalSchemaImpl;
import com.mulesoft.raml1.java.parser.model.datamodel.DataElement;
import com.mulesoft.raml1.java.parser.impl.datamodel.DataElementImpl;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.Trait;
import com.mulesoft.raml1.java.parser.impl.methodsAndResources.TraitImpl;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.ResourceType;
import com.mulesoft.raml1.java.parser.impl.methodsAndResources.ResourceTypeImpl;
import com.mulesoft.raml1.java.parser.model.declarations.AnnotationType;
import com.mulesoft.raml1.java.parser.impl.declarations.AnnotationTypeImpl;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.SecuritySchemaType;
import com.mulesoft.raml1.java.parser.impl.methodsAndResources.SecuritySchemaTypeImpl;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.SecuritySchema;
import com.mulesoft.raml1.java.parser.impl.methodsAndResources.SecuritySchemaImpl;
import com.mulesoft.raml1.java.parser.model.api.Library;
import com.mulesoft.raml1.java.parser.impl.api.LibraryImpl;



public class OLibraryImpl extends RAMLLanguageElementImpl implements OLibrary {

    public OLibraryImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected OLibraryImpl(){
        super();
    }


    @XmlElement(name="name")
    public String name(){
        return super.getAttribute("name", String.class);
    }


    @XmlElement(name="schemas")
    public List<GlobalSchema> schemas(){
        return super.getElements("schemas", GlobalSchemaImpl.class);
    }


    @XmlElement(name="types")
    public List<DataElement> types(){
        return super.getElements("types", DataElementImpl.class);
    }


    @XmlElement(name="traits")
    public List<Trait> traits(){
        return super.getElements("traits", TraitImpl.class);
    }


    @XmlElement(name="resourceTypes")
    public List<ResourceType> resourceTypes(){
        return super.getElements("resourceTypes", ResourceTypeImpl.class);
    }


    @XmlElement(name="annotationTypes")
    public List<AnnotationType> annotationTypes(){
        return super.getElements("annotationTypes", AnnotationTypeImpl.class);
    }


    @XmlElement(name="securitySchemaTypes")
    public List<SecuritySchemaType> securitySchemaTypes(){
        return super.getElements("securitySchemaTypes", SecuritySchemaTypeImpl.class);
    }


    @XmlElement(name="securitySchemes")
    public List<SecuritySchema> securitySchemes(){
        return super.getElements("securitySchemes", SecuritySchemaImpl.class);
    }


    @XmlElement(name="uses")
    public List<Library> uses(){
        return super.getElements("uses", LibraryImpl.class);
    }
}