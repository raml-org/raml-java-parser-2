package com.mulesoft.raml1.java.parser.impl.methodsAndResources;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.APIKeySettings;



public class APIKeySettingsImpl extends SecuritySchemaSettingsImpl implements APIKeySettings {

    public APIKeySettingsImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected APIKeySettingsImpl(){
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