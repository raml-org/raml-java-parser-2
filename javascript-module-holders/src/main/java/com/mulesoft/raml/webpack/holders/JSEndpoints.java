package com.mulesoft.raml.webpack.holders;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.script.Bindings;
import javax.script.ScriptEngine;

//import com.onpositive.ramlrest.persistence.ApiPersistence;
//import com.onpositive.ramlrest.persistence.model.ApiBean;

public class JSEndpoints extends AbstractJSWrapper {
	public enum ExecutionMode {
		REGISTER, EVAL;
	}
	
	private ExecutionInfoProvider provider;
	
	public String baseUrl;
	
	public Set<String> services = new HashSet<String>();
	
	public JSEndpoints(ScriptEngine engine, ExecutionInfoProvider provider) {
		super(engine);
		
		this.provider = provider;
	}

	public void exportService(Object service, Object requestGetter, String uri) {		
		if(ExecutionMode.REGISTER.equals(provider.getExecutionMode())) {
			services.add(uri);
			
			return;
		} else if(provider.isCurrentCall(uri)) {
			Bindings bindings = getBindings();
			
			bindings.put("service", service);
			bindings.put("getter", requestGetter);
						
			bindings.put("params", provider.getParams());
			
			bindings.put("body", provider.getRequestBody());
			
			eval("service(getter(null, params, body));", bindings);
		}
	}
			
	public interface ExecutionInfoProvider {
		public ExecutionMode getExecutionMode();
		
		public String getSrc();
		
		public String getAuthCfg();
		
		public Map<String, String> getParams();
		
		public String getRequestBody();
		
		boolean isCurrentCall(String serviceUrl);
	}
	
	public void doExport() {
//		if(ExecutionMode.REGISTER.equals(provider.getExecutionMode())) {
//			ApiBean api = new ApiBean(provider.getSrc(), provider.getAuthCfg());
//			
//			ApiPersistence.putApi(api, services);
//		}
	}
	
	public void setApi(Object api) {
		Bindings bindings = getBindings();
		
		bindings.put("owner", this);
		bindings.put("api", api);
		
		eval("owner.baseUrl = api.data.baseUri;", bindings);
		
		baseUrl = baseUrl.replace("http://", "").replace("https://", "");
		
		System.out.println("Api created: " + baseUrl);
	}
}
