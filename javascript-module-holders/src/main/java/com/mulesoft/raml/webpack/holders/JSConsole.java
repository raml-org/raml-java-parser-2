package com.mulesoft.raml.webpack.holders;

import javax.script.ScriptEngine;

public class JSConsole extends AbstractJSWrapper {
	public static JSConsole instance;
	
	private JSConsole(ScriptEngine engine) {
		super(engine);
		
		instance = this;
	}

	public void log(String text) {
		System.out.println(text);
	}
	
	public void warn(String text) {
		System.out.println("WARNING: " + text);
	}
	
	public String getClassName() {
		return "Console";
	}
	
	public static JSConsole getInstance(ScriptEngine engine) {
		return instance == null || instance.engine != engine ? new JSConsole(engine) : instance;
	}
}
