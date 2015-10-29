package com.mulesoft.raml1.java.parser.impl.datamodel;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.datamodel.RAMLPointerElement;
import com.mulesoft.raml1.java.parser.model.systemTypes.RAMLSelector;
import com.mulesoft.raml1.java.parser.impl.systemTypes.RAMLSelectorImpl;



public class RAMLPointerElementImpl extends DataElementImpl implements RAMLPointerElement {

    public RAMLPointerElementImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected RAMLPointerElementImpl(){
        super();
    }


    @XmlElement(name="target")
    public RAMLSelector target(){
        return super.getAttribute("target", RAMLSelectorImpl.class);
    }
}