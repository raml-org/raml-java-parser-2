package com.mulesoft.raml.webpack.holders;

import javax.script.ScriptEngine;

public class JSZ extends AbstractJSWrapper {
	public JSZ(ScriptEngine engine) {
		super(engine);
	}
	
	public String getClassName() {
		return "Z";
	}
}
