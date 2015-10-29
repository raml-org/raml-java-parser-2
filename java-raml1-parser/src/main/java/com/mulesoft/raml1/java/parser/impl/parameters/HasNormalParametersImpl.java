package com.mulesoft.raml1.java.parser.impl.parameters;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.impl.common.RAMLLanguageElementImpl;
import com.mulesoft.raml1.java.parser.model.parameters.HasNormalParameters;
import com.mulesoft.raml1.java.parser.model.datamodel.DataElement;
import com.mulesoft.raml1.java.parser.impl.datamodel.DataElementImpl;



public class HasNormalParametersImpl extends RAMLLanguageElementImpl implements HasNormalParameters {

    public HasNormalParametersImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected HasNormalParametersImpl(){
        super();
    }


    @XmlElement(name="queryParameters")
    public List<DataElement> queryParameters(){
        return super.getElements("queryParameters", DataElementImpl.class);
    }


    @XmlElement(name="headers")
    public List<DataElement> headers(){
        return super.getElements("headers", DataElementImpl.class);
    }


    @XmlElement(name="queryString")
    public DataElement queryString(){
        return super.getElement("queryString", DataElementImpl.class);
    }
}