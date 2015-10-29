package com.mulesoft.raml1.java.parser.model.api;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.model.common.RAMLLanguageElement;



public interface RAMLProject extends RAMLLanguageElement {

    @XmlElement(name="relatedProjects")
    List<RAMLProject> relatedProjects();


    @XmlElement(name="declaredApis")
    List<ApiDescription> declaredApis();


    @XmlElement(name="license")
    String license();


    @XmlElement(name="overview")
    String overview();


    @XmlElement(name="url")
    String url();

}