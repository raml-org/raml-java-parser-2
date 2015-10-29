package com.mulesoft.raml1.java.parser.impl.methodsAndResources;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.OAuth1SecuritySchemeSettings;
import com.mulesoft.raml1.java.parser.model.systemTypes.FixedUri;
import com.mulesoft.raml1.java.parser.impl.systemTypes.FixedUriImpl;
import com.mulesoft.raml1.java.parser.model.systemTypes.MarkdownString;
import com.mulesoft.raml1.java.parser.impl.systemTypes.MarkdownStringImpl;
import com.mulesoft.raml1.java.parser.model.declarations.AnnotationRef;
import com.mulesoft.raml1.java.parser.impl.declarations.AnnotationRefImpl;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.SecuritySchemaHook;
import com.mulesoft.raml1.java.parser.impl.methodsAndResources.SecuritySchemaHookImpl;



public class OAuth1SecuritySchemeSettingsImpl extends SecuritySchemaSettingsImpl implements OAuth1SecuritySchemeSettings {

    public OAuth1SecuritySchemeSettingsImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected OAuth1SecuritySchemeSettingsImpl(){
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


    @XmlElement(name="displayName")
    public String displayName(){
        return super.getAttribute("displayName", String.class);
    }


    @XmlElement(name="description")
    public MarkdownString description(){
        return super.getAttribute("description", MarkdownStringImpl.class);
    }


    @XmlElement(name="annotations")
    public List<AnnotationRef> annotations(){
        return super.getAttributes("annotations", AnnotationRefImpl.class);
    }


    @XmlElement(name="authentificationConfigurator")
    public SecuritySchemaHook authentificationConfigurator(){
        return super.getElement("authentificationConfigurator", SecuritySchemaHookImpl.class);
    }
}