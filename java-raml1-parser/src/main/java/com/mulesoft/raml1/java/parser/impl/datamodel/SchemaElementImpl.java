package com.mulesoft.raml1.java.parser.impl.datamodel;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.datamodel.SchemaElement;



public class SchemaElementImpl extends DataElementImpl implements SchemaElement {

    public SchemaElementImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected SchemaElementImpl(){
        super();
    }



}