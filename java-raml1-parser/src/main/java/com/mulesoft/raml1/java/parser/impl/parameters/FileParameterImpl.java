package com.mulesoft.raml1.java.parser.impl.parameters;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.impl.datamodel.DataElementImpl;
import com.mulesoft.raml1.java.parser.model.parameters.FileParameter;
import com.mulesoft.raml1.java.parser.model.systemTypes.ContentType;
import com.mulesoft.raml1.java.parser.impl.systemTypes.ContentTypeImpl;



public class FileParameterImpl extends DataElementImpl implements FileParameter {

    public FileParameterImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected FileParameterImpl(){
        super();
    }


    @XmlElement(name="fileTypes")
    public List<ContentType> fileTypes(){
        return super.getAttributes("fileTypes", ContentTypeImpl.class);
    }


    @XmlElement(name="minLength")
    public Double minLength(){
        return super.getAttribute("minLength", Double.class);
    }


    @XmlElement(name="maxLength")
    public Double maxLength(){
        return super.getAttribute("maxLength", Double.class);
    }
}