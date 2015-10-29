package com.mulesoft.raml1.java.parser.impl.systemTypes;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.systemTypes.RAMLSelector;



public class RAMLSelectorImpl extends StringTypeImpl implements RAMLSelector {

    public RAMLSelectorImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected RAMLSelectorImpl(){
        super();
    }



}