package com.mulesoft.raml1.java.parser.impl.datamodel;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.datamodel.NumberElement;



public class NumberElementImpl extends DataElementImpl implements NumberElement {

    public NumberElementImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected NumberElementImpl(){
        super();
    }


    @XmlElement(name="minimum")
    public Double minimum(){
        return super.getAttribute("minimum", Double.class);
    }


    @XmlElement(name="maximum")
    public Double maximum(){
        return super.getAttribute("maximum", Double.class);
    }


    @XmlElement(name="enum")
    public List<String> enum_(){
        return super.getAttributes("enum", String.class);
    }


    @XmlElement(name="format")
    public String format(){
        return super.getAttribute("format", String.class);
    }


    @XmlElement(name="multipleOf")
    public Double multipleOf(){
        return super.getAttribute("multipleOf", Double.class);
    }
}