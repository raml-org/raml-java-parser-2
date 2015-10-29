package com.mulesoft.raml1.java.parser.impl.api;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.api.Extension;



public class ExtensionImpl extends ApiImpl implements Extension {

    public ExtensionImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected ExtensionImpl(){
        super();
    }


    @XmlElement(name="masterRef")
    public String masterRef(){
        return super.getAttribute("masterRef", String.class);
    }
}