package com.mulesoft.raml1.java.parser.impl.declarations;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.impl.common.RAMLLanguageElementImpl;
import com.mulesoft.raml1.java.parser.model.declarations.AnnotationType;
import com.mulesoft.raml1.java.parser.model.datamodel.DataElement;
import com.mulesoft.raml1.java.parser.impl.datamodel.DataElementImpl;
import com.mulesoft.raml1.java.parser.model.declarations.AnnotationTarget;
import com.mulesoft.raml1.java.parser.impl.declarations.AnnotationTargetImpl;
import com.mulesoft.raml1.java.parser.model.systemTypes.MarkdownString;
import com.mulesoft.raml1.java.parser.impl.systemTypes.MarkdownStringImpl;



public class AnnotationTypeImpl extends RAMLLanguageElementImpl implements AnnotationType {

    public AnnotationTypeImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected AnnotationTypeImpl(){
        super();
    }


    @XmlElement(name="name")
    public String name(){
        return super.getAttribute("name", String.class);
    }


    @XmlElement(name="usage")
    public String usage(){
        return super.getAttribute("usage", String.class);
    }


    @XmlElement(name="parameters")
    public List<DataElement> parameters(){
        return super.getElements("parameters", DataElementImpl.class);
    }


    @XmlElement(name="allowMultiple")
    public Boolean allowMultiple(){
        return super.getAttribute("allowMultiple", Boolean.class);
    }


    @XmlElement(name="allowedTargets")
    public List<AnnotationTarget> allowedTargets(){
        return super.getAttributes("allowedTargets", AnnotationTargetImpl.class);
    }


    @XmlElement(name="displayName")
    public String displayName(){
        return super.getAttribute("displayName", String.class);
    }


    @XmlElement(name="description")
    public MarkdownString description(){
        return super.getAttribute("description", MarkdownStringImpl.class);
    }
}