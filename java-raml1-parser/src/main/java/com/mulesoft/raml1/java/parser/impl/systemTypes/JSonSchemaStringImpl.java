package com.mulesoft.raml1.java.parser.impl.systemTypes;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.systemTypes.JSonSchemaString;



public class JSonSchemaStringImpl extends SchemaStringImpl implements JSonSchemaString {

    public JSonSchemaStringImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected JSonSchemaStringImpl(){
        super();
    }



}