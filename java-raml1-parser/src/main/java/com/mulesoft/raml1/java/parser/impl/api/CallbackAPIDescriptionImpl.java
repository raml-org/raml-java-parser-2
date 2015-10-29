package com.mulesoft.raml1.java.parser.impl.api;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.api.CallbackAPIDescription;
import com.mulesoft.raml1.java.parser.model.api.Api;
import com.mulesoft.raml1.java.parser.impl.api.ApiImpl;



public class CallbackAPIDescriptionImpl extends ApiDescriptionImpl implements CallbackAPIDescription {

    public CallbackAPIDescriptionImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected CallbackAPIDescriptionImpl(){
        super();
    }


    @XmlElement(name="callbackFor")
    public Api callbackFor(){
        return super.getElement("callbackFor", ApiImpl.class);
    }
}