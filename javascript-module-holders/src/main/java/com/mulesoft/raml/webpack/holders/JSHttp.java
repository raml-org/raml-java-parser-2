package com.mulesoft.raml.webpack.holders;

import javax.script.Bindings;
import javax.script.ScriptEngine;

public class JSHttp extends AbstractJSWrapper {
	public Object request;
	
	public Object testObj;
	
	private boolean ssl;
	
	public JSHttp(ScriptEngine engine, boolean ssl) {
		super(engine);
		
		this.ssl = ssl;
		
		Bindings bindings = getBindings();
		
		bindings.put("owner", this);
		
		eval("owner.request = function(options, callback) {return owner.getRequest(options, callback);};", bindings);
	}
	
	public JSRequest getRequest(Object options, Object callback) {
		return new JSRequest(options, callback, ssl, engine);
	}

}
