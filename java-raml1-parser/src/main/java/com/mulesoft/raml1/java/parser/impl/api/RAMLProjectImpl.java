package com.mulesoft.raml1.java.parser.impl.api;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.impl.common.RAMLLanguageElementImpl;
import com.mulesoft.raml1.java.parser.model.api.RAMLProject;
import com.mulesoft.raml1.java.parser.impl.api.RAMLProjectImpl;
import com.mulesoft.raml1.java.parser.model.api.ApiDescription;
import com.mulesoft.raml1.java.parser.impl.api.ApiDescriptionImpl;



public class RAMLProjectImpl extends RAMLLanguageElementImpl implements RAMLProject {

    public RAMLProjectImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected RAMLProjectImpl(){
        super();
    }


    @XmlElement(name="relatedProjects")
    public List<RAMLProject> relatedProjects(){
        return super.getElements("relatedProjects", RAMLProjectImpl.class);
    }


    @XmlElement(name="declaredApis")
    public List<ApiDescription> declaredApis(){
        return super.getElements("declaredApis", ApiDescriptionImpl.class);
    }


    @XmlElement(name="license")
    public String license(){
        return super.getAttribute("license", String.class);
    }


    @XmlElement(name="overview")
    public String overview(){
        return super.getAttribute("overview", String.class);
    }


    @XmlElement(name="url")
    public String url(){
        return super.getAttribute("url", String.class);
    }
}