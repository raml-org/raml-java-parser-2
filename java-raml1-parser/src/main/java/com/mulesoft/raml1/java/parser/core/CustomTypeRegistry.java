package com.mulesoft.raml1.java.parser.core;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.SimpleBindings;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.codehaus.janino.JavaSourceClassLoader;
import org.codehaus.janino.util.resource.MapResourceFinder;
import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.eclipse.persistence.jaxb.UnmarshallerProperties;

import com.mulesoft.raml.webpack.holders.JSConsole;
import com.mulesoft.raml1.java.parser.registry.ModelRegistry;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

@SuppressWarnings("restriction")
public class CustomTypeRegistry {

	public CustomTypeRegistry(ScriptEngine engine, Wrapper wrapper) {
		this.engine = engine;
		this.wrapper = wrapper;
	}
	
	private ScriptEngine engine;
	
	private Wrapper wrapper;
	
	private LinkedHashSet<String> customClassPackages;

	@SuppressWarnings("unchecked")
	public CustomType customClassValue(Object jsNode) {

		try {
			List<UserClassData> classesList = new ArrayList<UserClassData>();
			Bindings bindings = this.getBindings();
			bindings.put("node", jsNode);
			bindings.put("env", this.wrapper);
			bindings.put("pkg", ModelRegistry.getInstance().rootPackage());
			ScriptObjectMirror svData = (ScriptObjectMirror) engine.eval("env.generateClasses(node.value(),pkg)",bindings);
			String jsonData = null;
			String valueName = null;
			if(svData != null){
				jsonData = svData.get("data").toString();
				valueName = svData.get("valueName").toString();
				ScriptObjectMirror classes = (ScriptObjectMirror) svData.get("classes");
				for(Object obj : classes.values()){
					ScriptObjectMirror cls = (ScriptObjectMirror) obj;
					String classContent = cls.get("content").toString();
					String qName = cls.get("qualifiedName").toString();
					String sName = cls.get("simpleName").toString();
					classesList.add(new UserClassData(qName, sName, classContent));
				}
			}
			String sName = classesList.get(0).getSimpleName();
			String qName = classesList.get(0).getQualifiedName();
			
			Class<? extends CustomType> customClass = loadCustomClassFromLibrary(sName);
			if(customClass==null){
				setClassLoaderParams(classesList);
				Class<?> c = customClassLoader.loadClass(qName);
				if(c!=null && CustomType.class.isAssignableFrom(c)){
					customClass = (Class<? extends CustomType>) c;
				}
			}			
			if(customClass != null){
				CustomType result = unmarshalCustomType(jsonData, (Class<? extends CustomType>)customClass);
				result.setRAMLValueName(valueName);
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		CustomType customType = new CustomType();
		customType.setFactory(this);
		return customType;
	}
	
	@SuppressWarnings("unchecked")
	private Class<? extends CustomType> loadCustomClassFromLibrary(String simpleName) {
		
		if(this.customClassPackages==null){
			this.customClassPackages = new LinkedHashSet<String>();
			try {			
				Enumeration<URL> resources = this.getClass().getClassLoader().getResources("customClassesPackages.txt");
				URL url;
				try{
					while((url = resources.nextElement()) != null){
						BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
						String ln;
						while((ln=br.readLine())!=null){
							ln = ln.trim();
							if(!ln.isEmpty()){
								this.customClassPackages.add(ln);
							}
						}
					}
				}
				catch(NoSuchElementException e){}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		Class<? extends CustomType> result=null;
		for(String pkg: this.customClassPackages){
			Class<?> clz = null;
			try {
				clz = this.getClass().getClassLoader().loadClass(pkg + "." + simpleName);
			} catch (ClassNotFoundException e) {}

			if(clz != null && CustomType.class.isAssignableFrom(clz)){
				result = (Class<? extends CustomType>) clz;
				break;
			}
		}
		return result;
	}

	private void setClassLoaderParams(List<UserClassData> classesList) {
		String packagePath = classesList.get(0).getPackagePath();		
		Set<String> set = this.jaxbIndexMap.get(packagePath);
		if(set==null){
			set = new LinkedHashSet<String>();
			this.jaxbIndexMap.put(packagePath, set);
		}
		for(UserClassData ucd : classesList){
			try {
				classCodeMap.put(ucd.getPath(), ucd.getBytes());
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			set.add(ucd.getSimpleName());
		}
		StringBuilder bld = new StringBuilder();
		for(String n : set){
			bld.append(n).append("\n");
		}
		String jaxbIndex = bld.toString();
		try {
			this.resourcesMap.put(packagePath+"/jaxb.properties","javax.xml.bind.context.factory=org.eclipse.persistence.jaxb.JAXBContextFactory".getBytes("UTF-8"));
			this.resourcesMap.put(packagePath+"/jaxb.index",jaxbIndex.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}

	private final HashMap<String, byte[]> resourcesMap = new HashMap<String, byte[]>();

	
	private final LinkedHashMap<String, byte[]> classCodeMap = new LinkedHashMap<String,byte[]>();
	
	private final ClassLoader customClassLoader = this.createClassLoader();
	
	private final HashMap<String,Set<String>> jaxbIndexMap = new HashMap<String, Set<String>>();


	public CustomType unmarshalCustomType(String jsonData, Class<? extends CustomType> clz) throws JAXBException, PropertyException {
		
		JAXBContext ctx = createJaxbContext(clz);		
		Unmarshaller um = ctx.createUnmarshaller();
		um.setProperty(UnmarshallerProperties.MEDIA_TYPE, "application/json");
		um.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, false);
		CustomType result = um.unmarshal(new StreamSource(new StringReader(jsonData)),clz).getValue();
		result.setFactory(this);
		return result;
	}


	private JAXBContext createJaxbContext(Class<? extends CustomType> clz) throws JAXBException {
		String qName = clz.getCanonicalName();
		String packageName = qName.substring(0, qName.lastIndexOf('.'));
		
		HashMap<String,String> props = new HashMap<String, String>();
		props.put("javax.xml.bind.context.factory", "org.eclipse.persistence.jaxb.JAXBContextFactory");
		JAXBContext ctx = JAXBContext.newInstance(packageName,clz.getClassLoader(),props);
		return ctx;
	}
	
	
	public String marshalCustomType(CustomType obj) throws JAXBException, PropertyException {
		Class<? extends CustomType> clz = obj.getClass();
		JAXBContext ctx = createJaxbContext(clz);		
		Marshaller m = ctx.createMarshaller();
		m.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		StringWriter sw = new StringWriter();
		m.marshal(obj, sw);
		String result = sw.toString();
		return result;
	}

	

	private ClassLoader createClassLoader(){

		ClassLoader cl = null;
		try {
			cl = new ResourceAwareJaninoClassLoader(this.classCodeMap,this.resourcesMap);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return cl;
	}
	
	
	private static class ResourceAwareJaninoClassLoader extends JavaSourceClassLoader {
		
		private Map<String, byte[]> resourcesMap;
		
		private ResourceAwareJaninoClassLoader(
				Map<String, byte[]> classCodeMap, Map<String, byte[]> resourcesMap) throws UnsupportedEncodingException {
			super(JavaNodeFactory.class.getClassLoader(),
					new MapResourceFinder(classCodeMap),
					(String)null);
			this.resourcesMap = resourcesMap;			
		}

		@Override
		protected URL findResource(final String name) {
			final byte[] bArr = resourcesMap.get(name);
			if(bArr==null){
				return super.findResource(name);
			}
			try {
				return new URL("file","",-1,"", new URLStreamHandler() {
					
					@Override
					protected URLConnection openConnection(URL u) throws IOException {
						return new URLConnection(u) {
							
							@Override
							public void connect() throws IOException {}
							
							public InputStream getInputStream() throws IOException {
					        	return new ByteArrayInputStream(bArr);
						    }
						};
					}
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
			return super.findResource(name);
		}
	}


	private static class UserClassData{
		
		public UserClassData(String qualifiedName, String simpleName, String content) {
			super();
			this.qualifiedName = qualifiedName;
			this.simpleName = simpleName;
			this.content = content;
		}

		private String qualifiedName;
		
		private String simpleName;
		
		private String content;

		public String getQualifiedName() {
			return qualifiedName;
		}

		public String getSimpleName() {
			return simpleName;
		}

		public String getContent() {
			return content;
		}
		
		public String getPath(){
			return this.getQualifiedName().replace('.','/')+".java";
		}
		
		public String getPackage(){
			String qName = this.getQualifiedName();
			return qName.substring(0, qName.lastIndexOf('.'));
		}
		
		public byte[] getBytes() throws UnsupportedEncodingException{
			return this.getContent().getBytes("UTF-8");
		}
		
		public String getPackagePath(){
			return this.getPackage().replace('.','/');
		}
		
	}
	
	public Bindings getBindings() {
		SimpleBindings bindings = new SimpleBindings();
		bindings.put("console", JSConsole.getInstance(engine));
		return bindings;
	}

}
