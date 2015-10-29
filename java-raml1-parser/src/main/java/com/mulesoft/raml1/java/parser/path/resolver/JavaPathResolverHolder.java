package com.mulesoft.raml1.java.parser.path.resolver;

import java.util.List;

import javax.script.ScriptEngine;

import com.mulesoft.raml.webpack.holders.AbstractJSWrapper;

@SuppressWarnings("restriction")
public class JavaPathResolverHolder extends AbstractJSWrapper{
	
	
	public JavaPathResolverHolder(ScriptEngine engine) {
		this(engine,null);		
	}
	
	
	public JavaPathResolverHolder(ScriptEngine engine, IJavaPathResolver resolver) {
		super(engine);
		this.resolver = resolver;
	}

	
	private IJavaPathResolver resolver;

	
	
	public Object content(String path){
		return this.resolver.content(path);
	}
	
	
	public Object list(String path){
		
		List<String> fileNames = this.resolver.list(path.toString());
		StringBuilder bld = new StringBuilder("[");
		if(fileNames==null||fileNames.size()==0){
			bld.append("]");
		}
		else{
			for(String f: fileNames){
				bld.append("'").append(f).append("'").append(",");
			}
			bld.setCharAt(bld.length()-1, ']');
		}
		Object arr = this.eval(bld.toString(),getBindings());
		return arr;
	}
	
	
	public IJavaPathResolver getResolver() {
		return resolver;
	}
	
	

	public void setResolver(IJavaPathResolver resolver) {
		this.resolver = resolver;
	}
	

}
