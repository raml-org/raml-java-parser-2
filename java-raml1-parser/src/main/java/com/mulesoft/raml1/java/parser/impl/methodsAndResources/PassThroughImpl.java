package com.mulesoft.raml1.java.parser.impl.methodsAndResources;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.PassThrough;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.PassThroughSettings;
import com.mulesoft.raml1.java.parser.impl.methodsAndResources.PassThroughSettingsImpl;



public class PassThroughImpl extends SecuritySchemaImpl implements PassThrough {

    public PassThroughImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected PassThroughImpl(){
        super();
    }


    @XmlElement(name="settings")
    public PassThroughSettings settings(){
        return super.getElement("settings", PassThroughSettingsImpl.class);
    }
}