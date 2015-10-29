package com.mulesoft.raml1.java.parser.impl.datamodel;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.datamodel.ScriptHookElement;



public class ScriptHookElementImpl extends DataElementImpl implements ScriptHookElement {

    public ScriptHookElementImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected ScriptHookElementImpl(){
        super();
    }


    @XmlElement(name="declaredIn")
    public String declaredIn(){
        return super.getAttribute("declaredIn", String.class);
    }


    @XmlElement(name="interfaceName")
    public String interfaceName(){
        return super.getAttribute("interfaceName", String.class);
    }
}