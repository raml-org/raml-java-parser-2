package com.mulesoft.raml1.java.parser.impl.systemTypes;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.systemTypes.RelativeUri;



public class RelativeUriImpl extends UriTemplateImpl implements RelativeUri {

    public RelativeUriImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected RelativeUriImpl(){
        super();
    }



}