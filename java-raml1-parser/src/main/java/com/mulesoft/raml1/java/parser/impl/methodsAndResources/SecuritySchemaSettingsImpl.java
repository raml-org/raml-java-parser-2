package com.mulesoft.raml1.java.parser.impl.methodsAndResources;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.core.JavaElementNode;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.SecuritySchemaSettings;



public class SecuritySchemaSettingsImpl extends JavaElementNode implements SecuritySchemaSettings {

    public SecuritySchemaSettingsImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected SecuritySchemaSettingsImpl(){
        super();
    }



}