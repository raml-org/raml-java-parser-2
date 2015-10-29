package com.mulesoft.raml1.java.parser.impl.systemTypes;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.systemTypes.SchemaString;



public class SchemaStringImpl extends StringTypeImpl implements SchemaString {

    public SchemaStringImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected SchemaStringImpl(){
        super();
    }



}