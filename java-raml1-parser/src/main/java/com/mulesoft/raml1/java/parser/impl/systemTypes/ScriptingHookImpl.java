package com.mulesoft.raml1.java.parser.impl.systemTypes;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.systemTypes.ScriptingHook;



public class ScriptingHookImpl extends StringTypeImpl implements ScriptingHook {

    public ScriptingHookImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected ScriptingHookImpl(){
        super();
    }



}