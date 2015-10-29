package com.mulesoft.raml.webpack.holders;

import java.io.Reader;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import javax.script.SimpleBindings;

public abstract class AbstractJSWrapper {
	public ScriptEngine engine;
	
	public AbstractJSWrapper(ScriptEngine engine) {
		this.engine = engine;
		
		System.out.println("Instance created: " + this.getClass().getSimpleName());
	}
	
	public Object eval(String script, Bindings bindings) {
		try {
			return engine.eval(script, bindings);
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Object eval(Reader reader, Bindings bindings) {
		try {
			return engine.eval(reader, bindings);
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Bindings getBindings() {
		SimpleBindings bindings = new SimpleBindings();
				
		bindings.put("console", JSConsole.getInstance(engine));
		
		return bindings;
	}
}
