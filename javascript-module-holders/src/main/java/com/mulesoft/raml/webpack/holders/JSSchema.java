package com.mulesoft.raml.webpack.holders;

import javax.script.ScriptEngine;

public class JSSchema extends AbstractJSWrapper {
	public JSSchema(ScriptEngine engine) {
		super(engine);
	}
	
	public String getClassName() {
		// TODO Auto-generated method stub
		return "Schema";
	}
}