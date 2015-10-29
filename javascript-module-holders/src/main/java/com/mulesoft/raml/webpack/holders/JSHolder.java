package com.mulesoft.raml.webpack.holders;

import javax.script.ScriptEngine;

public class JSHolder extends AbstractJSWrapper {
	public JSHolder(ScriptEngine engine) {
		super(engine);
	}
	
	public Object holded;
}
