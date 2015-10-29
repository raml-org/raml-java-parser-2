package com.mulesoft.raml.webpack.holders;

import javax.script.Bindings;
import javax.script.ScriptEngine;

public class JSReportManager extends AbstractJSWrapper {
	public Object ReportManager;
	
	public JSReportManager(ScriptEngine engine) {
		super(engine);
		
		Bindings bindings = getBindings();
		
		bindings.put("owner", this);
		bindings.put("manager", new ReportManager());
		
		eval("owner.ReportManager = function() {return manager;};", bindings);
	}
			
	public static class ReportManager {
		public ReportManager() {
			
		}
		
		public void serializeStep(Object step) {
			
		}
	}
}
