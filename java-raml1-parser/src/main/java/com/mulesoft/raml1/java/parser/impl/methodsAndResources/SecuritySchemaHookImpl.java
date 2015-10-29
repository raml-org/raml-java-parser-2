package com.mulesoft.raml1.java.parser.impl.methodsAndResources;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.core.JavaElementNode;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.SecuritySchemaHook;
import com.mulesoft.raml1.java.parser.model.datamodel.DataElement;
import com.mulesoft.raml1.java.parser.impl.datamodel.DataElementImpl;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.SecuritySchemaHookScript;
import com.mulesoft.raml1.java.parser.impl.methodsAndResources.SecuritySchemaHookScriptImpl;



public class SecuritySchemaHookImpl extends JavaElementNode implements SecuritySchemaHook {

    public SecuritySchemaHookImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected SecuritySchemaHookImpl(){
        super();
    }


    @XmlElement(name="parameters")
    public List<DataElement> parameters(){
        return super.getElements("parameters", DataElementImpl.class);
    }


    @XmlElement(name="script")
    public SecuritySchemaHookScript script(){
        return super.getAttribute("script", SecuritySchemaHookScriptImpl.class);
    }
}