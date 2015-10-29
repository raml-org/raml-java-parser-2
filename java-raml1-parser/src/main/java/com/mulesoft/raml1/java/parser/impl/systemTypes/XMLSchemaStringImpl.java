package com.mulesoft.raml1.java.parser.impl.systemTypes;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.systemTypes.XMLSchemaString;



public class XMLSchemaStringImpl extends SchemaStringImpl implements XMLSchemaString {

    public XMLSchemaStringImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected XMLSchemaStringImpl(){
        super();
    }



}