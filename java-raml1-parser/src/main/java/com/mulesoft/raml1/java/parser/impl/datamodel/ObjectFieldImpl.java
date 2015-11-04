package com.mulesoft.raml1.java.parser.impl.datamodel;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.datamodel.ObjectField;
import com.mulesoft.raml1.java.parser.model.datamodel.DataElement;
import com.mulesoft.raml1.java.parser.impl.datamodel.DataElementImpl;
import com.mulesoft.raml1.java.parser.model.datamodel.pointer;
import com.mulesoft.raml1.java.parser.impl.datamodel.pointerImpl;



public class ObjectFieldImpl extends DataElementImpl implements ObjectField {

    public ObjectFieldImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected ObjectFieldImpl(){
        super();
    }


    @XmlElement(name="properties")
    public List<DataElement> properties(){
        return super.getElements("properties", DataElementImpl.class);
    }


    @XmlElement(name="minProperties")
    public Double minProperties(){
        return super.getAttribute("minProperties", Double.class);
    }


    @XmlElement(name="maxProperties")
    public Double maxProperties(){
        return super.getAttribute("maxProperties", Double.class);
    }


    @XmlElement(name="additionalProperties")
    public DataElement additionalProperties(){
        return super.getElement("additionalProperties", DataElementImpl.class);
    }


    @XmlElement(name="patternProperties")
    public List<DataElement> patternProperties(){
        return super.getElements("patternProperties", DataElementImpl.class);
    }


    @XmlElement(name="discriminator")
    public pointer discriminator(){
        return super.getAttribute("discriminator", pointerImpl.class);
    }


    @XmlElement(name="discriminatorValue")
    public String discriminatorValue(){
        return super.getAttribute("discriminatorValue", String.class);
    }
}