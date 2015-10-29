package com.mulesoft.raml1.java.parser.model.api;

import javax.xml.bind.annotation.XmlElement;



public interface CallbackAPIDescription extends ApiDescription {

    @XmlElement(name="callbackFor")
    Api callbackFor();

}