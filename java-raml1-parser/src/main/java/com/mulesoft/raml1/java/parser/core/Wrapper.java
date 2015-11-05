package com.mulesoft.raml1.java.parser.core;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

import com.mulesoft.raml.webpack.holders.AbstractJSWrapper;

@SuppressWarnings("restriction")
public class Wrapper extends AbstractJSWrapper {

	public Wrapper(ScriptEngine engine) {
		super(engine);
	}

	public Object createApi;

	public Object getClassName;

	public Object generateClasses;

	public void setCreateApi(Object createApi) {
		this.createApi = createApi;
	}

	public void setClassNameGetter(Object getClassName) {
		this.getClassName = getClassName;
	}

	public void setGenerateClasses(Object generateClasses) {
		this.generateClasses = generateClasses;
	}

	public Object getApiJsObject(String ramlFile) {

		Bindings bindings = this.getBindings();
		bindings.put("environment", this);
		String ramlPath = ramlFile;
		ramlPath = ramlPath.replace(System.getProperty("file.separator"), "/");
		bindings.put("ramlPath", ramlPath);

		Object obj = null;
		try {
			obj = engine.eval("environment.createApi(ramlPath)", bindings);
		} catch (ScriptException e) {
			e.printStackTrace();
		}

		return obj;
	}

}
