package com.mulesoft.raml1.java.parser.impl.methodsAndResources;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.Oath1;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.OAuth1SecuritySchemeSettings;
import com.mulesoft.raml1.java.parser.impl.methodsAndResources.OAuth1SecuritySchemeSettingsImpl;



public class Oath1Impl extends SecuritySchemaImpl implements Oath1 {

    public Oath1Impl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected Oath1Impl(){
        super();
    }


    @XmlElement(name="settings")
    public OAuth1SecuritySchemeSettings settings(){
        return super.getElement("settings", OAuth1SecuritySchemeSettingsImpl.class);
    }
}