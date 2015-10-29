package com.mulesoft.raml.webpack.holders;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import javax.script.Bindings;
import javax.script.ScriptEngine;

public class JSFileSystem extends AbstractJSWrapper {	

	private HashMap<String, Object> files = new HashMap<String, Object>();
	
	static JSFileSystem instance = null;
	
	private static String ROOT_PATH;
		
	private JSFileSystem(ScriptEngine engine, String _rootPath) {		
		super(engine);
		
		instance = this;
		ROOT_PATH = _rootPath;
	}
	
	public String getClassName() {
		return "FS";
	}
	
	public void setAuthCfg(String config) {
		files.put("/auth.cfg", config);
	}
	
	public boolean existsSync(String path) {
		if(new File(ROOT_PATH + path).exists()){
			return true;
		}
		return this.files.get(path) != null;
	}
	
	public void writeFileSync(String fileName, Object data, Object options) {
		//System.out.println("Called: writeFileSync(" + fileName + ", " + data + ", " + options + ")");
		
		files.put(fileName, data);
	}
	
	public void writeFileSync(String fileName, Object data) {
		//System.out.println("Called: writeFileSync(" + fileName + ", " + data + ")");
		
		files.put(fileName, data);
	}
	
	public void appendFileSync(String fileName, Object data, Object options) {
		System.out.println("Called: appendFileSync(" + fileName + ", " + data + ", " + options + ")");
		
		Object value = files.get(fileName);
		value = value!=null ? value.toString()+data.toString() : data;
		files.put(fileName, value);
	}
	
	public Object readFileSync(String fileName, Object options) {
		
		return this.readFileSync(fileName);
	}
	
	public Object readFileSync(String fileName) {	
		
		String res = this.doReadFile(ROOT_PATH + fileName);
		if(res != null){
			return res;
		}	
		return this.files.get(fileName);		
	}
	
	public Object readdirSync(String path){
		File dir = new File(ROOT_PATH + path);
		if(!dir.isDirectory()){
			return null;
		}
		String[] fileNames = dir.list();
		StringBuilder bld = new StringBuilder("[");
		for(String f: fileNames){
			bld.append("'").append(f).append("'").append(",");
		}
		bld.setCharAt(bld.length()-1, ']');
		Object arr = this.eval(bld.toString(),getBindings());
		return arr;
	}
	
	public Stats lstatSync(String path){
		return new Stats(new File(ROOT_PATH,path).getAbsolutePath());
	}
	
	public void unlinkSync(String path) {
		System.out.println("Called: unlinkSync(" + path + ")");
		
		files.remove(path);
	}
	
	public static JSFileSystem getInstance(ScriptEngine engine, String rootPath) {
		return instance == null || instance.engine != engine ? new JSFileSystem(engine,rootPath) : instance;
	}
	
	
	private String doReadFile(String path){
		
		try {
			File file = new File(path);
			if(!file.exists()){
				return null;
			}
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			byte[] buf = new byte[1024];

			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			int l = 0;
			while((l=bis.read(buf))>=0){
				bos.write(buf, 0, l);
			}
			
			bis.close();
			
			String result = new String(bos.toByteArray(),"utf-8");
			return result;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;		
	}
	
	
	
	public static class Stats{
		
		private final String path;
		
		public Stats(String path) {
			this.path = path;
		}

		public boolean isDirectory(){
			return new File(this.path).isDirectory();			
		}
		
	}
}
