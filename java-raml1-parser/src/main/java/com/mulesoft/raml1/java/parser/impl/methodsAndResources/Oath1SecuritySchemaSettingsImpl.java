package com.mulesoft.raml1.java.parser.impl.methodsAndResources;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.Oath1SecuritySchemaSettings;
import com.mulesoft.raml1.java.parser.model.systemTypes.FixedUri;
import com.mulesoft.raml1.java.parser.impl.systemTypes.FixedUriImpl;



public class Oath1SecuritySchemaSettingsImpl extends SecuritySchemaSettingsImpl implements Oath1SecuritySchemaSettings {

    public Oath1SecuritySchemaSettingsImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected Oath1SecuritySchemaSettingsImpl(){
        super();
    }


    @XmlElement(name="requestTokenUri")
    public FixedUri requestTokenUri(){
        return super.getAttribute("requestTokenUri", FixedUriImpl.class);
    }


    @XmlElement(name="authorizationUri")
    public FixedUri authorizationUri(){
        return super.getAttribute("authorizationUri", FixedUriImpl.class);
    }


    @XmlElement(name="tokenCredentialsUri")
    public FixedUri tokenCredentialsUri(){
        return super.getAttribute("tokenCredentialsUri", FixedUriImpl.class);
    }


    @XmlElement(name="signatures")
    public List<String> signatures(){
        return super.getAttributes("signatures", String.class);
    }
}