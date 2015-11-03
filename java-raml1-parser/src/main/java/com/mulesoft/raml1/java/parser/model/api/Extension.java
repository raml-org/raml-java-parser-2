package com.mulesoft.raml1.java.parser.model.api;

import javax.xml.bind.annotation.XmlElement;



public interface Extension extends Api {

    @XmlElement(name="usage")
    String usage();


    @XmlElement(name="masterRef")
    String masterRef();


    @XmlElement(name="title")
    String title();

}