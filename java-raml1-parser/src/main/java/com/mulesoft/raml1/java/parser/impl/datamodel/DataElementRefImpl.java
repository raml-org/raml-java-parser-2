package com.mulesoft.raml1.java.parser.impl.datamodel;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.impl.systemTypes.ReferenceImpl;
import com.mulesoft.raml1.java.parser.model.datamodel.DataElementRef;



public class DataElementRefImpl extends ReferenceImpl implements DataElementRef {

    public DataElementRefImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected DataElementRefImpl(){
        super();
    }



}