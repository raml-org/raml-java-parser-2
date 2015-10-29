package com.mulesoft.raml.webpack.holders;

import javax.script.ScriptEngine;

public class JSPlatformExecution extends AbstractJSWrapper {
	public String type = "java";
	
	public JSPlatformExecution(ScriptEngine engine) {
		super(engine);
	}
}