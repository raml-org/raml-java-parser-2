package com.mulesoft.raml1.java.parser.impl.methodsAndResources;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.impl.common.RAMLLanguageElementImpl;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.SecuritySchemaType;
import com.mulesoft.raml1.java.parser.model.datamodel.DataElement;
import com.mulesoft.raml1.java.parser.impl.datamodel.DataElementImpl;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.SecuritySchemaPart;
import com.mulesoft.raml1.java.parser.impl.methodsAndResources.SecuritySchemaPartImpl;



public class SecuritySchemaTypeImpl extends RAMLLanguageElementImpl implements SecuritySchemaType {

    public SecuritySchemaTypeImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected SecuritySchemaTypeImpl(){
        super();
    }


    @XmlElement(name="requiredSettings")
    public List<DataElement> requiredSettings(){
        return super.getElements("requiredSettings", DataElementImpl.class);
    }


    @XmlElement(name="describedBy")
    public SecuritySchemaPart describedBy(){
        return super.getElement("describedBy", SecuritySchemaPartImpl.class);
    }
}