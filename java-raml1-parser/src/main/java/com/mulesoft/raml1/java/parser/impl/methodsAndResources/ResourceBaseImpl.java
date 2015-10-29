package com.mulesoft.raml1.java.parser.impl.methodsAndResources;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.impl.common.RAMLLanguageElementImpl;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.ResourceBase;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.Method;
import com.mulesoft.raml1.java.parser.impl.methodsAndResources.MethodImpl;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.TraitRef;
import com.mulesoft.raml1.java.parser.impl.methodsAndResources.TraitRefImpl;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.ResourceTypeRef;
import com.mulesoft.raml1.java.parser.impl.methodsAndResources.ResourceTypeRefImpl;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.SecuritySchemaRef;
import com.mulesoft.raml1.java.parser.impl.methodsAndResources.SecuritySchemaRefImpl;
import com.mulesoft.raml1.java.parser.model.datamodel.DataElement;
import com.mulesoft.raml1.java.parser.impl.datamodel.DataElementImpl;



public class ResourceBaseImpl extends RAMLLanguageElementImpl implements ResourceBase {

    public ResourceBaseImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected ResourceBaseImpl(){
        super();
    }


    @XmlElement(name="methods")
    public List<Method> methods(){
        return super.getElements("methods", MethodImpl.class);
    }


    @XmlElement(name="is")
    public List<TraitRef> is(){
        return super.getAttributes("is", TraitRefImpl.class);
    }


    @XmlElement(name="type")
    public ResourceTypeRef type(){
        return super.getAttribute("type", ResourceTypeRefImpl.class);
    }


    @XmlElement(name="securedBy")
    public List<SecuritySchemaRef> securedBy(){
        return super.getAttributes("securedBy", SecuritySchemaRefImpl.class);
    }


    @XmlElement(name="uriParameters")
    public List<DataElement> uriParameters(){
        return super.getElements("uriParameters", DataElementImpl.class);
    }
}