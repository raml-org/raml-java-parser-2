package com.mulesoft.raml1.java.parser.impl.api;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.impl.common.RAMLLanguageElementImpl;
import com.mulesoft.raml1.java.parser.model.api.ApiDescription;
import com.mulesoft.raml1.java.parser.model.api.Api;
import com.mulesoft.raml1.java.parser.impl.api.ApiImpl;
import com.mulesoft.raml1.java.parser.model.api.ScriptSpec;
import com.mulesoft.raml1.java.parser.impl.api.ScriptSpecImpl;



public class ApiDescriptionImpl extends RAMLLanguageElementImpl implements ApiDescription {

    public ApiDescriptionImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected ApiDescriptionImpl(){
        super();
    }


    @XmlElement(name="apiFiles")
    public List<Api> apiFiles(){
        return super.getElements("apiFiles", ApiImpl.class);
    }


    @XmlElement(name="script")
    public List<ScriptSpec> script(){
        return super.getElements("script", ScriptSpecImpl.class);
    }


    @XmlElement(name="type")
    public String type(){
        return super.getAttribute("type", String.class);
    }
}