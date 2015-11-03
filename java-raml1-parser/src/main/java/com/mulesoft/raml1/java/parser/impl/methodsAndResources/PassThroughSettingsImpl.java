package com.mulesoft.raml1.java.parser.impl.methodsAndResources;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.PassThroughSettings;



public class PassThroughSettingsImpl extends SecuritySchemaSettingsImpl implements PassThroughSettings {

    public PassThroughSettingsImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected PassThroughSettingsImpl(){
        super();
    }


    @XmlElement(name="queryParameterName")
    public String queryParameterName(){
        return super.getAttribute("queryParameterName", String.class);
    }


    @XmlElement(name="headerName")
    public String headerName(){
        return super.getAttribute("headerName", String.class);
    }
}