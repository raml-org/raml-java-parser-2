package com.mulesoft.raml1.java.parser.impl.api;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.impl.common.RAMLLanguageElementImpl;
import com.mulesoft.raml1.java.parser.model.api.ScriptSpec;



public class ScriptSpecImpl extends RAMLLanguageElementImpl implements ScriptSpec {

    public ScriptSpecImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected ScriptSpecImpl(){
        super();
    }


    @XmlElement(name="language")
    public String language(){
        return super.getAttribute("language", String.class);
    }


    @XmlElement(name="content")
    public String content(){
        return super.getAttribute("content", String.class);
    }
}