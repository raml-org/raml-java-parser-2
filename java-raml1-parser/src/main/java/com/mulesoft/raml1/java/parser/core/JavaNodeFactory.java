package com.mulesoft.raml1.java.parser.core;

import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import javax.script.Bindings;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleBindings;
import jdk.nashorn.api.scripting.ScriptObjectMirror;

import com.mulesoft.raml.webpack.holders.JSChildProcess;
import com.mulesoft.raml.webpack.holders.JSConsole;
import com.mulesoft.raml.webpack.holders.JSFileSystem;
import com.mulesoft.raml.webpack.holders.JSHolder;
import com.mulesoft.raml.webpack.holders.JSHttp;
import com.mulesoft.raml.webpack.holders.JSPlatformExecution;
import com.mulesoft.raml.webpack.holders.JSReportManager;
import com.mulesoft.raml.webpack.holders.JSSchema;
import com.mulesoft.raml.webpack.holders.JSZ;
import com.mulesoft.raml1.java.parser.impl.api.ApiImpl;
import com.mulesoft.raml1.java.parser.model.api.Api;
import com.mulesoft.raml1.java.parser.path.resolver.IJavaPathResolver;
import com.mulesoft.raml1.java.parser.path.resolver.JavaFSPathResolver;
import com.mulesoft.raml1.java.parser.path.resolver.JavaPathResolverHolder;
import com.mulesoft.raml1.java.parser.registry.ModelRegistry;

@SuppressWarnings("restriction")
public class JavaNodeFactory{

	private String rootPath = "";

	public JavaNodeFactory(){
		init();
	}

	private ScriptEngine engine;

	public Wrapper wrapper;

	private CustomTypeRegistry customTypesRegistry;

	private JavaPathResolverHolder pathResolverHolder;

	//private HashMap<String,Class<?>> userClasses = new HashMap<String, Class<?>>();


	public Api createApi(String apiFile){
		return new ApiImpl(this.wrapper.getApiJsObject(apiFile),this);
	}


	public <T,S extends T> T getAttribute(Object jsNode, String name, Class<S> clazz){
		return getValue(jsNode, name, clazz);
	}


	public <T,S extends T> List<T>  getAttributes(Object jsNode, String name, Class<S> clazz) {
		return getValueList(jsNode, name, clazz);
	}


	public <T,S extends T> T getElement(Object jsNode, String name, Class<S> clazz) {
		return getObject(jsNode, name, clazz);
	}


	public <T,S extends T> List<T> getElements(Object jsNode, String name, Class<S> clazz) {
		return getObjectList(jsNode, name, clazz);
	}

	public String attributeValue(Object jsNode) {
		String result = null;
		try {
			Bindings bindings = this.getBindings();
			bindings.put("node", jsNode);
			Object obj = engine.eval("node.value()",bindings);
			if(obj != null){
				result = obj.toString();
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		return result;
	}



	private <T,S extends T> T getValue(Object jsNode, String name, Class<S> clazz) {

		T result = null;
		try {
			Bindings bindings = this.getBindings();
			bindings.put("node", jsNode);
			Object jsResult = engine.eval("node." + name + "()",bindings);
			if(jsResult==null){
				return null;
			}
			result = convert(clazz, jsResult);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		return result;
	}


	@SuppressWarnings("unchecked")
	private <T,S extends T> T convert(Class<S> clazz, Object jsResult)
			throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
		T result;
		if(jsResult==null){
			result =  null;
		}
		else if(clazz == String.class){
			result = clazz.cast(jsResult.toString());
		}
		else if(clazz == Boolean.class){
			result = clazz.cast(Boolean.parseBoolean(jsResult.toString()));
		}
		else if(Number.class.isAssignableFrom(clazz)){
			result = clazz.cast(Double.parseDouble(jsResult.toString()));
		}
		else if(clazz.isEnum()){
			result =  clazz.cast(Enum.valueOf((Class<? extends Enum>)clazz, jsResult.toString()));
		}
		else{
			Constructor<S> constr = clazz.getConstructor(Object.class,JavaNodeFactory.class);
			result = constr.newInstance(jsResult,this);
		}
		return result;
	}


	@SuppressWarnings("unchecked")
	private <T,S extends T> List<T> getValueList(Object jsNode, String name, Class<S> clazz) {

		ArrayList<Object> list = new ArrayList<Object>();
		try {
			Bindings bindings = this.getBindings();
			bindings.put("node", jsNode);
			ScriptObjectMirror jsResult = (ScriptObjectMirror) engine.eval("node." + name + "()",bindings);
			if(jsResult!=null){
				for(Object obj : jsResult.values()){
					list.add(convert(clazz,obj));
				}
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		ArrayList<T> list1 = new ArrayList<T>();
		for(Object o : list){
			list1.add((T)o);
		}
		return list1;
	}

	private <T,S extends T> T getObject(Object jsNode, String name, Class<S> clazz) {
		T result = null;
		try {
			Bindings bindings = this.getBindings();
			bindings.put("node", jsNode);
			Object jsResult = engine.eval("node." + name + "()",bindings);
			if(jsResult==null){
				return null;
			}
			Class <? extends S> actualClazz = getActualClass(jsResult,clazz);
			Constructor<? extends S> constr = actualClazz.getConstructor(Object.class,JavaNodeFactory.class);
			result = constr.newInstance(jsResult,this);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		return result;
	}


	private <S> Class<? extends S> getActualClass(Object jsNode, Class<S> clazz) {

		Bindings bindings = this.getBindings();
		bindings.put("node", jsNode);
		try {
			Object classNameObj = engine.eval("node.wrapperClassName()",bindings);
			if(classNameObj!=null){
				String className = classNameObj.toString();
				if(!clazz.getSimpleName().equals(className)){
					Class<? extends S> result = ModelRegistry.getInstance().getModelClass(className,clazz);
					if(result != null){
						return result;
					}
				}
			}

		} catch (ScriptException e) {
			e.printStackTrace();
		}
		return clazz;
	}


	private <T,S extends T> List<T> getObjectList(Object jsNode, String name, Class<S> clazz) {

		ArrayList<T> list = new ArrayList<T>();
		try {
			Bindings bindings = this.getBindings();
			bindings.put("node", jsNode);
			ScriptObjectMirror jsResult = (ScriptObjectMirror) engine.eval("node." + name + "()",bindings);
			if(jsResult!=null){
				for(Object obj : jsResult.values()){
					Class <? extends S> actualClazz = getActualClass(obj,clazz);
					Constructor<? extends S> constr = actualClazz.getConstructor(Object.class,JavaNodeFactory.class);
					list.add(constr.newInstance(obj,this));
				}
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		return list;
	}


	public Bindings getBindings() {
		SimpleBindings bindings = new SimpleBindings();
		bindings.put("console", JSConsole.getInstance(engine));
		return bindings;
	}

	public CustomType customClassValue(Object jsNode) {
		return this.customTypesRegistry.customClassValue(jsNode);
	}



	private void init() {
		engine = new ScriptEngineManager().getEngineByName("nashorn");

		wrapper = new Wrapper(this.engine);

		customTypesRegistry = new CustomTypeRegistry(this.engine,this.wrapper);

		pathResolverHolder = new JavaPathResolverHolder(engine,new JavaFSPathResolver());

		Bindings bindings = new SimpleBindings();

		bindings.put("endpoints", new Object());
		bindings.put("z", new JSZ(engine));
		bindings.put("schema", new JSSchema(engine));
		bindings.put("fs", JSFileSystem.getInstance(engine,this.rootPath));
		bindings.put("executionReportManager", new JSReportManager(engine));
		bindings.put("http", new JSHttp(engine, false));
		bindings.put("https", new JSHttp(engine, true));
		bindings.put("javaPathResolver", pathResolverHolder);
		bindings.put("platformExecution", new JSPlatformExecution(engine));
		bindings.put("child_process", new JSChildProcess(engine,this.rootPath));
		bindings.put("_spawn_sync", new JSChildProcess(engine,this.rootPath));
		bindings.put("console", JSConsole.getInstance(engine));
		bindings.put("apiCreatorWrapper", this.wrapper);
		bindings.put("typescript", new JSHolder(engine));
		bindings.put("_try_thread_sleep", new JSHolder(engine));


		try {
			Reader scriptSrc = new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("bundle.js"),"UTF-8");
			CompiledScript script = ((Compilable)engine).compile(scriptSrc);

			bindings.put("script", script);

			script.eval(bindings);

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}


	public void setPathResolver(IJavaPathResolver resolver) {
		this.pathResolverHolder.setResolver(resolver);
	}



}
