package com.mulesoft.raml.webpack.holders;

import java.util.HashMap;

import javax.script.Bindings;
import javax.script.ScriptEngine;

public class JSResponse extends AbstractJSWrapper {
	private HashMap<String, Object> handlers = new HashMap<String, Object>();
	
	public String encoding;
	
	public HashMap<String, String> headers;
	
	public String statusCode = "blah";

	private String text;
	
	private String escapedText;

	private String code;
	
	public Object content = new Object();
	
	public JSResponse(ScriptEngine engine, String text, String code, HashMap<String, String> headers) {
		super(engine);		
		this.headers = headers;
		this.code = code;		
		this.text = text;
		this.escapedText = text.replaceAll("([\\\\'\\r\\n\\t\\f\\n])","\\\\$1");		
	}
	
	private void onError(JSError error) {
		Bindings bindings = getBindings();
		
		if(handlers.get("error") != null) {
			bindings.put("callback", handlers.get("error"));
			bindings.put("error", error);
			
			eval("callback(error);", bindings);
		}
	}
	
	private void onSuccess() {
		Bindings bindings = getBindings();
		
		if(handlers.get("data") != null) {
			bindings.put("owner", this);
			bindings.put("callback", handlers.get("data"));
			bindings.put("text", this.text);
			eval("callback('"+escapedText+"');", bindings);
		}
	}
	
	private void onEnd() {
		Bindings bindings = getBindings();
		
		if(handlers.get("end") != null) {			
			bindings.put("callback", handlers.get("end"));
			bindings.put("jmap", headers);
			
			String[] array = new String[headers.size()];
			
			int count = 0;
			
			for(String header: headers.keySet()) {
				array[count++] = header;
			}
			
			bindings.put("keys", array);
												
			eval("var headers = {}; for(var i in keys) {headers[String(keys[i])] = String(jmap.get(keys[i]))} callback('" + code + "', headers, '" + escapedText + "');", bindings);
		}
	}
	
	public void end() {
		try {
			onSuccess();
		} catch(Throwable t) {
			onError(new JSError());
		} finally {
			onEnd();
		}
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
	
	public JSResponse on(Object options, Object callback) {		
		handlers.put(options.toString(), callback);
		
		return this;
	}
}
