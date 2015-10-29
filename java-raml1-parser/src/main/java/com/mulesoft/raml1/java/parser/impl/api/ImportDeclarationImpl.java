package com.mulesoft.raml1.java.parser.impl.api;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.impl.common.RAMLSimpleElementImpl;
import com.mulesoft.raml1.java.parser.model.api.ImportDeclaration;
import com.mulesoft.raml1.java.parser.model.api.Library;
import com.mulesoft.raml1.java.parser.impl.api.LibraryImpl;



public class ImportDeclarationImpl extends RAMLSimpleElementImpl implements ImportDeclaration {

    public ImportDeclarationImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected ImportDeclarationImpl(){
        super();
    }


    @XmlElement(name="key")
    public String key(){
        return super.getAttribute("key", String.class);
    }


    @XmlElement(name="value")
    public Library value(){
        return super.getElement("value", LibraryImpl.class);
    }
}