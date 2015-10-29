package com.mulesoft.raml1.java.parser.impl.methodsAndResources;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.impl.common.RAMLLanguageElementImpl;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.SecuritySchema;
import com.mulesoft.raml1.java.parser.model.systemTypes.MarkdownString;
import com.mulesoft.raml1.java.parser.impl.systemTypes.MarkdownStringImpl;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.SecuritySchemaPart;
import com.mulesoft.raml1.java.parser.impl.methodsAndResources.SecuritySchemaPartImpl;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.SecuritySchemaSettings;
import com.mulesoft.raml1.java.parser.impl.methodsAndResources.SecuritySchemaSettingsImpl;



public class SecuritySchemaImpl extends RAMLLanguageElementImpl implements SecuritySchema {

    public SecuritySchemaImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected SecuritySchemaImpl(){
        super();
    }


    @XmlElement(name="name")
    public String name(){
        return super.getAttribute("name", String.class);
    }


    @XmlElement(name="type")
    public String type(){
        return super.getAttribute("type", String.class);
    }


    @XmlElement(name="description")
    public MarkdownString description(){
        return super.getAttribute("description", MarkdownStringImpl.class);
    }


    @XmlElement(name="describedBy")
    public SecuritySchemaPart describedBy(){
        return super.getElement("describedBy", SecuritySchemaPartImpl.class);
    }


    @XmlElement(name="settings")
    public SecuritySchemaSettings settings(){
        return super.getElement("settings", SecuritySchemaSettingsImpl.class);
    }
}