package com.mulesoft.raml1.java.parser.impl.methodsAndResources;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.APIKey;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.APIKeySettings;
import com.mulesoft.raml1.java.parser.impl.methodsAndResources.APIKeySettingsImpl;



public class APIKeyImpl extends SecuritySchemaImpl implements APIKey {

    public APIKeyImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected APIKeyImpl(){
        super();
    }


    @XmlElement(name="settings")
    public APIKeySettings settings(){
        return super.getElement("settings", APIKeySettingsImpl.class);
    }
}