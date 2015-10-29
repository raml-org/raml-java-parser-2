package com.mulesoft.raml1.java.parser.model.methodsAndResources;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.model.api.Library;



public interface ResourceType extends ResourceBase {

    @XmlElement(name="name")
    String name();


    @XmlElement(name="usage")
    String usage();


    @XmlElement(name="uses")
    List<Library> uses();

}