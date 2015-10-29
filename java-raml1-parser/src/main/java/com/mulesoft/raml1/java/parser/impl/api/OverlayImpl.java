package com.mulesoft.raml1.java.parser.impl.api;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.api.Overlay;



public class OverlayImpl extends ApiImpl implements Overlay {

    public OverlayImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected OverlayImpl(){
        super();
    }


    @XmlElement(name="masterRef")
    public String masterRef(){
        return super.getAttribute("masterRef", String.class);
    }
}