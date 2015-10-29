package com.mulesoft.raml1.java.parser.impl.api;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.impl.common.RAMLSimpleElementImpl;
import com.mulesoft.raml1.java.parser.model.api.GlobalSchema;
import com.mulesoft.raml1.java.parser.model.systemTypes.SchemaString;
import com.mulesoft.raml1.java.parser.impl.systemTypes.SchemaStringImpl;



public class GlobalSchemaImpl extends RAMLSimpleElementImpl implements GlobalSchema {

    public GlobalSchemaImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected GlobalSchemaImpl(){
        super();
    }


    @XmlElement(name="key")
    public String key(){
        return super.getAttribute("key", String.class);
    }


    @XmlElement(name="value")
    public SchemaString value(){
        return super.getAttribute("value", SchemaStringImpl.class);
    }
}