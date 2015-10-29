package com.mulesoft.raml.webpack.holders;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import javax.script.SimpleBindings;

public class JSChildProcess extends AbstractJSWrapper {
	public Object spawn;
	
	private String rootPath;
			
	public JSChildProcess(ScriptEngine engine, String rootPath) {
		super(engine);
		
		this.rootPath = rootPath;
		
		Bindings bindings = getBindings();
		
		bindings.put("owner", this);
		
		eval("owner.spawn=function(arg1, arg2, arg3){return owner.newChildProcess(arg1, arg2, arg3); this.console = console;};", bindings);
		
		System.out.println();
	}
	
	public ChildProcess newChildProcess(String command, Object args, Object options) {
		return new ChildProcess(command, args, options, engine,this.rootPath);
	}
	
	public static class ChildProcess {
		private ScriptEngine engine;
		
		public String call;
		
		public Object stdin;
		
		private String rootPath;
		
		public ChildProcess(String command, Object args, Object options, ScriptEngine engine, String rootPath) {		
			this.engine = engine;
			this.rootPath = rootPath;
			
			Bindings bindings = new SimpleBindings();
			
			bindings.put("args", args);
			bindings.put("owner", this);
			bindings.put("console", JSConsole.getInstance(engine));
			
			try {
				engine.eval("var require = function(arg) {return owner.require(arg);}; owner.call = args[1]; owner.stdin = {end: function() {return owner.stdinEnd();}};", bindings);
												
				String instrumented = call.replace("response.on('end', function() {", "response.on('end', function(rcode, rheaders, rtext) {");
				instrumented= instrumented.replace("statusCode: response.statusCode, headers: response.headers, text: responseText", "statusCode: rcode, headers: rheaders, text: rtext");
								
				engine.eval(instrumented, bindings);
			} catch (ScriptException e) {
				e.printStackTrace();
			}
		}
		
		public Object require(String key) {
			if("http".equals(key) || "https".equals(key)) {
				return new JSHttp(engine, "https".equals(key));
			} else if("fs".equals(key)) {
				return JSFileSystem.getInstance(engine,this.rootPath);
			}
			
			return null;
		}
		
		public void stdinEnd() {
			
		}
	}
}