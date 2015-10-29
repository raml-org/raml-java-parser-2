package com.mulesoft.raml1.java.parser.impl.methodsAndResources;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.Oath2;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.OAuth2SecuritySchemeSettings;
import com.mulesoft.raml1.java.parser.impl.methodsAndResources.OAuth2SecuritySchemeSettingsImpl;



public class Oath2Impl extends SecuritySchemaImpl implements Oath2 {

    public Oath2Impl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected Oath2Impl(){
        super();
    }


    @XmlElement(name="settings")
    public OAuth2SecuritySchemeSettings settings(){
        return super.getElement("settings", OAuth2SecuritySchemeSettingsImpl.class);
    }
}