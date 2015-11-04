package com.mulesoft.raml1.java.parser.impl.datamodel;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.core.JavaElementNode;
import com.mulesoft.raml1.java.parser.model.datamodel.XMLInfo;



public class XMLInfoImpl extends JavaElementNode implements XMLInfo {

    public XMLInfoImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected XMLInfoImpl(){
        super();
    }


    @XmlElement(name="name")
    public String name(){
        return super.getAttribute("name", String.class);
    }


    @XmlElement(name="namespace")
    public String namespace(){
        return super.getAttribute("namespace", String.class);
    }


    @XmlElement(name="prefix")
    public String prefix(){
        return super.getAttribute("prefix", String.class);
    }


    @XmlElement(name="attribute")
    public Boolean attribute(){
        return super.getAttribute("attribute", Boolean.class);
    }


    @XmlElement(name="wrapped")
    public Boolean wrapped(){
        return super.getAttribute("wrapped", Boolean.class);
    }
}