package com.mulesoft.raml1.java.parser.impl.methodsAndResources;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.Oath2SecurySchemaSettings;
import com.mulesoft.raml1.java.parser.model.systemTypes.FixedUri;
import com.mulesoft.raml1.java.parser.impl.systemTypes.FixedUriImpl;



public class Oath2SecurySchemaSettingsImpl extends SecuritySchemaSettingsImpl implements Oath2SecurySchemaSettings {

    public Oath2SecurySchemaSettingsImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected Oath2SecurySchemaSettingsImpl(){
        super();
    }


    @XmlElement(name="accessTokenUri")
    public FixedUri accessTokenUri(){
        return super.getAttribute("accessTokenUri", FixedUriImpl.class);
    }


    @XmlElement(name="authorizationUri")
    public FixedUri authorizationUri(){
        return super.getAttribute("authorizationUri", FixedUriImpl.class);
    }


    @XmlElement(name="authorizationGrants")
    public List<String> authorizationGrants(){
        return super.getAttributes("authorizationGrants", String.class);
    }


    @XmlElement(name="scopes")
    public List<String> scopes(){
        return super.getAttributes("scopes", String.class);
    }
}