package com.mulesoft.raml1.java.parser.impl.methodsAndResources;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.impl.common.RAMLLanguageElementImpl;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.SecuritySchemaSettings;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.SecuritySchemaHook;
import com.mulesoft.raml1.java.parser.impl.methodsAndResources.SecuritySchemaHookImpl;



public class SecuritySchemaSettingsImpl extends RAMLLanguageElementImpl implements SecuritySchemaSettings {

    public SecuritySchemaSettingsImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected SecuritySchemaSettingsImpl(){
        super();
    }


    @XmlElement(name="authentificationConfigurator")
    public SecuritySchemaHook authentificationConfigurator(){
        return super.getElement("authentificationConfigurator", SecuritySchemaHookImpl.class);
    }
}