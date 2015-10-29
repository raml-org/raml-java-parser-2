package com.mulesoft.raml1.java.parser.impl.methodsAndResources;

import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.impl.systemTypes.ScriptingHookImpl;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.SecuritySchemaHookScript;



public class SecuritySchemaHookScriptImpl extends ScriptingHookImpl implements SecuritySchemaHookScript {

    public SecuritySchemaHookScriptImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected SecuritySchemaHookScriptImpl(){
        super();
    }



}